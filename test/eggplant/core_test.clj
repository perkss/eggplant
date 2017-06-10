(ns eggplant.core-test
  (:require [clojure.test :refer :all]
            [eggplant.core :refer :all]
            [clojure.string :as str]))

(deftest give-test
  (testing "Check the when defines variable"
    (is (= 2 (given 2 test-data-name)))))

(deftest when-we-process-test
  (testing "Check the when calls the function"
    (is (= 4 (when-we-process + 2 2)))))

(deftest then-we-expect-test
  (testing "Test the then works as expected"
    (is (true? (then-we-expect 2 2)))))

(deftest give-when-we-process-test
  (testing "Check the when calls the function"
    (is (= 4 (when-we-process + 2 (given 2 test-data-name))))))

(deftest then-we-expect-test-fail
  (testing "Test the then will fail on negatives"
    (is (true? (then-we-do-not-expect 2 3)))))

(deftest example-specification-true
  (testing "A full length example specification which is true 4 * 2 = 8"
    (then-we-expect 8 (when-we-process * 2 (given 4 test-data-name)))))

(deftest example-specification-false
  (testing "A full length example specification which is false 4 * 2 = 6 ! False"
    (then-we-do-not-expect 6 (when-we-process * 2 (given 4 test-data-name)))))

(defspec example-specification-with-strings
  (testing "String upper case specification"
    (then-we-expect "TOM" (when-we-process str/upper-case (given "tom" test-data-name)))))

(defspec example-specification-with-thread-macro
  (testing "Test with Thread Macro"
    (given 2 test-data-name
          (then-we-expect 4 (when-we-process * 2 test-data-name)))))
