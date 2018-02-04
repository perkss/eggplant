(ns eggplant.core-test
  (:require [clojure.test :refer :all]
            [eggplant.core :refer :all]
            [clojure.string :as str]))

(deftest give-test
  (testing "Check the when defines variable"
    (is (= 2 (given 2 test-data)))))

(deftest when-we-process-test
  (testing "Check the when calls the function"
    (is (= 4 (when-we-process + 2 2)))))

(deftest then-we-expect-test
  (testing "Test the then works as expected"
    (is (true? (then-we-expect 2 2)))))

(deftest give-when-we-process-test
  (testing "Check the when calls the function"
    (given 2 test-data
           (is (= 4 (when-we-process + 2 test-data))))))

(deftest then-we-expect-test-fail
  (testing "Test the then will fail on negatives"
    (is (true? (then-we-do-not-expect 2 3)))))

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

(defspec example-table-test-2
  
       (testing "Example table test 2"
         (test-where  (expect (function-under-test +) (assertion = )) 
                   
                   (->Row + [3 3] 6)
                   (->Row + [ 3 3] 6)  )))

(defspec example-table-test-3
  
       (testing "Example table test 3"
         (-> (expect (function-under-test +) (assertion = )) 
             (test-where
              
              (->Row + [3 3] 6)
              (->Row + [ 3 3] 6)))))
