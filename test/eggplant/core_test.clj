(ns eggplant.core-test
  (:require [clojure.test :refer :all]
            [eggplant.core :refer :all]))

(deftest given-test
  (testing "Check the when defines variable"
    (is (= 2 (given 2 as test-data)))))

(deftest function-under-test-method-test
  (testing "Check the value is the function under test")
  (is (= + (function-under-test +))))

(deftest assertion-test
  (testing "Check the value assertion function is returned")
  (is (= = (assertion =))))

(deftest when-we-process-test
  (testing "Check the when calls the function"
    (is (= 4 (when-we-process + 2 2)))))

(deftest then-we-expect-test
  (testing "Test the then works as expected"
    (is (true? (then-we-expect 2 2)))))

(deftest then-we-do-not-expect-test
  (testing "Test the then we do not expect works as expected"
    (is (true? (then-we-do-not-expect 2 3)))))

(deftest give-when-we-process-test
  (testing "Check the when calls the function"
    (given 2 as test-data
           (is (= 4 (when-we-process + 2 test-data))))))

(deftest then-we-expect-fail-test
  (testing "Test the then will fail on negatives"
    (is (true? (then-we-do-not-expect 2 3)))))

