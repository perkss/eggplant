# eggplant 
# Behaviour Driven Development (BDD) Library for Clojure

## Details

Eggplant is a very young behaviour driven development (BDD) library for Clojure. Eggplant will focus on data driven testing to enable a data driven language such as Clojure to be adequately tested. It will use specifications written in a very simple user friendly language to enforce executable tests that can be automated and continue living documentation of these tests. 

Our Motto: **_"Simplicity is key"_**

Eggplant just works, it has simple to read phrases and a BDD style test can be written in under 30 seconds, we do not try and over complicate things. Except reading right to left!! (See the examples and you will understand) 


## Features (Under Development): 
1. Simplicity - a key feature we do not want to over complicate things.
2. Four keywords: given, when-we-process, then-we-expect, then-we-do-not-expect form the BDD style of testing. 
3. Data driven testing using data tables. Import of data tables from CSV for non technical users to write specifications.
 
## Examples

``` clojure

;; Preferable way of writing user readable
(defspec example-specification-multiplication
         (testing "Test with Thread Macro given"
           (given 2 test-data
                  (then-we-expect 4 (when-we-process * 2 test-data)))))

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
    
```
## Contribute

Always looking for contribution so please reach out and take some of the issues or create new ones. Beginner friendly.
 
## Dependency

Available: [![Clojars Project](https://img.shields.io/clojars/v/eggplant.svg)](https://clojars.org/eggplant)

#### Leiningen/Boot
``` 
    [eggplant "0.1.0-SNAPSHOT"] 
```
#### Gradle  
```
    compile "eggplant:eggplant:0.1.0-SNAPSHOT"
```
#### Maven  
```
    <dependency>
      <groupId>eggplant</groupId>
      <artifactId>eggplant</artifactId>
      <version>0.1.0-SNAPSHOT</version>
    </dependency>
```
 
## Thanks

Thanks to some key players in the Clojure space that makes this fun all possible: 
 
- Rich Hickey for [Clojure](http://clojure.org).
- Colin Fleming for [Cursive](https://cursiveclojure.com).
- Phil Hagelberg for [Leiningen](http://leiningen.org).
- Stuart Sierra, Chas Emerick, Allen Rohner, and Stuart Halloway for [Clojure Test](https://clojure.github.io/clojure/clojure.test-api.html).

