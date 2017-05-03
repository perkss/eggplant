(ns eggplant.core
  (:require [clojure.test :refer :all]))

;; TODO Multiple parameters allowed
(defn given [x]
  (var-get (def var x)))

(defn when-we-process [testFn & data]
  (apply testFn data))

;; TODO need to make this equal work for all types
(defn then-we-expect [expected actual]
  (is (true? (= expected actual))))

(defn then-we-do-not-expect [expected actual]
  (is (false? (= expected actual))))

;; TODO define a defSpecification fn that refers to defTest



