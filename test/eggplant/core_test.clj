(ns eggplant.core-test
  (:require [clojure.test :refer :all]
            [eggplant.core :refer :all]))

(deftest provided-test
  (testing "Check the when defines variable"
    (is 5 (provided 5))))

(deftest when-we-test
  (testing "Check the when calls the function"
    (is 4 (when-we #(+ %1 2) 2))))

(deftest then-we-expect-test
  (testing "Test the then works as expected"
    (is true (then-we-expect 2 2))))

(deftest example-specification-true
  (testing "A full length example specification which is true"
    (is true (then-we-expect 4 (when-we #(+ %1 2) (provided 2))))))

(deftest example-specification-false
  (testing "A full length example specification which is true"
    (is false (then-we-expect 2 (when-we #(+ %1 2) (provided 2))))))