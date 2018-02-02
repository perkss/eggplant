(ns eggplant.core
  (:require [clojure.test :refer :all]))

(defmacro given
  ^{:safe true}
  [& args] `(as-> ~@args))

(defn when-we-process [test-fn & data]
  (apply test-fn data))

;; TODO need to make this equal work for all types
(defn then-we-expect [expected actual]
  (is (true? (= expected actual))))

(defn then-we-do-not-expect [expected actual]
  (is (false? (= expected actual))))

(defmacro defspec
  ^{:safe true}
  [& args] `(deftest ~@args))

;;(defn execute-row [func data] (apply func data))

(for [test-row [row1 row2]] (execute-row + test-row))


(defrecord Row [function-under-test args expected])

 (def row1 [1 2 3])

(def row2 [3 4 5])

(def row3 (Row. + row1 6))

 (def row4 (->Row + row1 6))

(defn execute-row [func data assertion] (assertion (apply func (:args data)) (:expected data)))


(execute-row + row3 =)

(for [test-row [row4 row3]] (execute-row + test-row =))

(defn where [& args] (for [test-row args] (execute-row + test-row =)))

 (where row3 row4)

;; build a expect data type from (expect test-func = expected)
(defrecord Expect [test-func assertion])
(expect + =)

;; Do the macro inline call so can have (expect -> where)
(defn where [expect & args] (for [test-row args] (is (true?  (execute-row (:test-func expect) test-row (:assertion expect))))))


(where (expect + =) row3 row4)



