(ns eggplant.core
  (:require [clojure.test :refer :all]))

(defn multi-args? [data]
  (and
    (vector? data)
    (= (get (frequencies data) 'as) (/ (count data) 3))))

(defmacro given
  ([data & args]
   (if (multi-args? data)
     `(let [~@(mapcat #(list (nth % 2) (first %)) (partition 3 data))] ~@args)
     `(as-> ~@(cons data (rest args))))))

(defmacro function-under-test
  [function-under-test]
  function-under-test)

(defmacro assertion
  [assertion] assertion)

(defn when-we-process [test-fn & data]
  (apply test-fn data))

;; TODO need to make this equal work for all types
(defn then-we-expect [expected actual]
  (is (true?
       (= expected actual))))

(defn then-we-do-not-expect [expected actual]
  (is (false?
       (= expected actual))))

(defmacro defspec
  [& args]
  `(deftest ~@args))

(defrecord Row [args expected])

(defn test-data-row [args expected] (->Row args expected))

(defn- execute-row [func data assertion]
  (assertion (apply func (:args data)) (:expected data)))

(defrecord Expect [test-func assertion])

(defn expect [test-func assertion]
  (->Expect test-func assertion))

(defn- check-row [expect test-row]
  (is (true?
       (execute-row (:test-func expect) test-row (:assertion expect)))))

(defn where [expected & args]
  (every? true?
          (for [test-row args]
            (check-row expected test-row))))

