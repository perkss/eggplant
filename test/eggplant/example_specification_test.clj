(ns eggplant.example-specification-test
  (:require  [clojure.test :refer :all]
             [eggplant.core :refer :all]
             [clojure.string :as str]))

(defspec example-specification-true
  (testing "A full length example specification which is true 4 * 2 = 8"
    (given 4 test-data
           (then-we-expect 8 (when-we-process * 2 test-data)))))

(defspec example-specification-false
  (testing "A full length example specification which is false 4 * 2 = 6 ! False"
    (given 4 test-data
           (then-we-do-not-expect 6 (when-we-process * 2 test-data)))))

(defspec example-specification-with-strings
  (testing "String upper case specification"
    (given "tom" test-data
           (then-we-expect "TOM" (when-we-process str/upper-case test-data)))))

(defspec example-specification-multiplication
  (testing "Test with Thread Macro given"
    (given 2 test-data
           (then-we-expect 4 (when-we-process * 2 test-data)))))

(defspec example-table-test
  (testing "Example table testing + with assertion of ="
    (-> (expect (function-under-test +) (assertion =))
        (where
         (test-data-row [3 3] 6)
         (test-data-row [4 4] 8)
         (test-data-row [2 3] 5)))))

(defspec example-table-test-not-equals
  (testing "Example table of multiply and assertion !="
    (-> (expect (function-under-test *) (assertion not=))
        (where
         (test-data-row [3 3] 3)
         (test-data-row [4 4] 8)
         (test-data-row [2 3] 5)))))

