(ns eggplant.example-specification-test
  (:require  [clojure.test :refer :all]
             [eggplant.core :refer :all]))

(defspec multiplying-two-numbers
  (specification
   {:given "a input of :a and :b"
    :when  "we #* :c"
    :then  "we can expect a :result"
    :data {:a 3 :b 4 :result 12}}))

(defspec change-a-string-to-uppercase
  (specification
   {:given "a input of :a"
    :when  "we convert it to #clojure.string/upper-case"
    :then  "we can expect a :result"
    :data {:a "hello" :result "HELLO"}}))

(defspec finding-the-max-of-two-numbers
  (specification
   {:expect "the #max of :a and :b"
    :where  {:a 2 :b 3 :expected 3}}))