(ns eggplant.core-test
  (:require [clojure.test :refer :all]
            [eggplant.core :refer :all]))

(deftest provided-test
  (testing "Check the when defines variable"
    (is 2 (given 2))))

(deftest when-we-process-test
  (testing "Check the when calls the function"
    (is 4 (when-we-process #(+ %1 2) 2))))

(deftest then-we-expect-test
  (testing "Test the then works as expected"
    (is (true? (then-we-expect 2 2)))))

(deftest then-we-expect-test-fail
  (testing "Test the then will fail on negatives"
    (is (false? (then-we-expect 2 3)))))

(deftest example-specification-true
  (testing "A full length example specification which is true"
    (is (true? (then-we-expect 4 (when-we-process #(+ %1 2) given))))))

(deftest example-specification-false
  (testing "A full length example specification which is true"
    (is (false? (then-we-expect 2 (when-we-process #(+ %1 2) given))))))