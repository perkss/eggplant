# eggplant 
# Behaviour Driven Development (BDD) Library for Clojure

## Details

Eggplant is a very young behaviour driven development (BDD) library for Clojure. Eggplant will focus on data driven testing to enable a data driven language such as Clojure to be adequately tested. It will use specifications written in a very simple user friendly language to enforce executable tests that can be automated and continue living documentation of these tests. 

Our Motto: **_"Simplicity is key"_**

Eggplant just works, it has simple to read phrases and a BDD style test can be written in under 30 seconds, we do not try and over complicate things. Except reading right to left!! 


## Features (Under Development): 
1. Simplicity - a key feature we do not want to over complicate things.
2. Three keywords: Given, When-We-Process, Then-We-Expect form the BDD style of testing. 
3. Data driven testing using data tables. Import of data tables from CSV for non technical users to write specifications. 

## Contribute

Always looking for contribution so please reach out and take some of the issues or create new ones. Beginner friendly.
  
# Examples

``` clojure

(ns eggplant.core-test
  (:require [clojure.test :refer :all]
            [eggplant.core :refer :all]
            [clojure.string :as str]))

(deftest give-test
  (testing "Check the when defines variable"
    (is (= 2 (given 2)))))

(deftest when-we-process-test
  (testing "Check the when calls the function"
    (is (= 4 (when-we-process + 2 2)))))

(deftest then-we-expect-test
  (testing "Test the then works as expected"
    (is (true? (then-we-expect 2 2)))))

(deftest give-when-we-process-test
  (testing "Check the when calls the function"
    (is (= 4 (when-we-process + 2 (given 2))))))

(deftest then-we-expect-test-fail
  (testing "Test the then will fail on negatives"
    (is (false? (then-we-expect 2 3)))))

(deftest example-specification-true
  (testing "A full length example specification which is true 4 * 2 = 8"
    (is (true? (then-we-expect 8 (when-we-process * 2 (given 4)))))))

(deftest example-specification-false
  (testing "A full length example specification which is false 4 * 2 = 6 ! False"
    (is (false? (then-we-expect 6 (when-we-process * 2 (given 4)))))))

(deftest example-specification-with-strings
  (testing "String upper case specification"
    (is (true? (then-we-expect "TOM" (when-we-process str/upper-case (given "tom")))))))

    
```

## Thanks

Thanks to some key players in the Clojure space that makes this fun all possible: 
 
- Rich Hickey for [Clojure](http://clojure.org).
- Colin Fleming for [Cursive](https://cursiveclojure.com).
- Phil Hagelberg for [Leiningen](http://leiningen.org).

