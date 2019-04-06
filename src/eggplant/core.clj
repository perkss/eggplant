(ns eggplant.core
  (:require [clojure.test :refer :all]))

(defn- get-keyword-from-str
  "Extracts words beginning with : to represent keywords"
  [str]
  (map keyword (map #(clojure.string/replace % #":" "")
                    (re-seq #":\w+" str))))

(defn get-fn-name-from-str
  [input]
  (let [[ns fn-name] (clojure.string/split
                      (clojure.string/trim
                       (first (re-seq #"#.*?\s"
                                      (str input " ")))) #"/")]
    (if (nil? fn-name)
      ["clojure.core" (clojure.string/replace
                       ns
                       #"#" "")]
      [(clojure.string/replace
        ns
        #"#" "") fn-name])))

(defn- get-fn-from-str
  "Extracts words beginning with # to represent fn"
  [str]
  (let [[ns fn-name] (get-fn-name-from-str str)]
    (ns-resolve (symbol ns)
                (symbol fn-name))))

(defn- select-values [map ks]
  (remove nil? (reduce #(conj %1 (map %2)) [] ks)))

(defn- apply-values [map f ks]
  (apply f (select-values map ks)))

(defn- given-when-then
  [data]
  (testing (str (:given data) (:when data) (:then data))
    (let [test-data (:data data)
          keywords (get-keyword-from-str (:given data))
          fn-under-test (get-fn-from-str (:when data))
          expected ((first (get-keyword-from-str (:then data))) test-data)
          result (apply-values test-data fn-under-test keywords)]
      (is (= expected
             result)))))

(defn- expect-where
  [data]
  (let [expect-phrase (:expect data)
        keywords (get-keyword-from-str expect-phrase)
        expected (-> data :where :expected)
        fn-under-test (get-fn-from-str expect-phrase)
        result (apply-values (:where data) fn-under-test keywords)]
    (testing expect-phrase (is (= expected result)))))

(defn specification
  [data]
  (if (not (nil? (:where data)))
    (expect-where data)
    (given-when-then data)))

(defmacro defspec
  [& specs]
  `(deftest ~@specs))

