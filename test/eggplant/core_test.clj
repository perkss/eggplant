(ns eggplant.core-test
  (:require [clojure.test :refer :all]
            [eggplant.core :refer :all]))

(deftest given-test
  (testing "Check the when defines variable"
    (is 5 (given 5))))

(deftest when-test
  (testing "Check the when calls the function"
    (is 4 (when #(+ %1 2) 2))))

(deftest then-test
  (testing "Test the then works as expected"
    (is true (then 2 2))))
