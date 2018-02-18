# eggplant 
# Behaviour Driven Development (BDD) Library for Clojure

## Details

Eggplant is a behaviour driven development (BDD) library for Clojure. Eggplant's focus is on data driven testing to enable a data driven language such as Clojure to be adequately tested. It will use specifications written in a very simple user friendly language to enforce executable tests that can be automated along with providing living documentation. 

Our Motto: **_"Simplicity is key"_**

Eggplant just works, it has simple to read phrases and a BDD style test can be written in under 30 seconds, we do not try and over complicate things.


## Features: 
1. Simplicity: a key feature we do not want to over complicate things.
2. Four keywords: given, when-we-process, then-we-expect, then-we-do-not-expect form the BDD style of testing. 
3. Data driven: Data driven testing using data tables with the where clause. 
 
## Examples

``` clojure
[eggplant.core :refer :all]

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

(defspec example-table-spec
  (testing "Example table testing + with assertion of ="
    (-> (expect (function-under-test +) (assertion =))
        (where
         (test-data-row [3 3] 6)
         (test-data-row [4 4] 8)
         (test-data-row [2 3] 5)))))
         
(defspec build-account-spec
  (testing "Example table testing formulation of a test-account record"
    (-> (expect (function-under-test get) (assertion =))
        (where
         (test-data-row [test-account :balance] 0)
         (test-data-row [test-account :first-name] "egg")
         (test-data-row [test-account :last-name] "plant")))))


```
## Contribute

Always looking for contribution so please reach out and take some of the issues or create new ones. Beginner friendly.
 
## Dependency

Available: [![Clojars Project](https://img.shields.io/clojars/v/eggplant.svg)](https://clojars.org/eggplant)

#### Leiningen/Boot
``` 
    [eggplant "0.1.1"] 
```
#### Gradle  
```
    compile "eggplant:eggplant:0.1.1"
```
#### Maven  
```
    <dependency>
      <groupId>eggplant</groupId>
      <artifactId>eggplant</artifactId>
      <version>0.1.1</version>
    </dependency>
```
 
## Thanks

Thanks to some key players in the Clojure space that makes this fun all possible: 
 
- Rich Hickey for [Clojure](http://clojure.org).
- Colin Fleming for [Cursive](https://cursiveclojure.com).
- Phil Hagelberg for [Leiningen](http://leiningen.org).
- Stuart Sierra, Chas Emerick, Allen Rohner, and Stuart Halloway for [Clojure Test](https://clojure.github.io/clojure/clojure.test-api.html).

