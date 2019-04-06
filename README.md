# eggplant 
# Behaviour Driven Development (BDD) Library for Clojure

## Details

Eggplant is a behaviour driven development (BDD) library for Clojure. Eggplant's focus is on data driven testing to enable a data driven language such as Clojure to be adequately tested. It will use specifications written in a very simple user friendly language to enforce executable tests that can be automated along with providing living documentation. The power of Clojure maps will be our friend!

Blog: https://perkss.github.io/#/clojure#text-body

Our Motto: **_"Simplicity is key"_**

Eggplant just works, it has simple to read phrases and a BDD style test can be written in under 30 seconds, we do not try and over complicate things.

Runs the same as `clojure.test` so will work in any IDE and with any driver such as `lein test` displaying the same differences between expected and actual.

## Features: 
1. Simplicity: a key feature we do not want to over complicate things.
2. Keywords: given, when, then, or expect, where form the BDD style of testing.
3. Data driven: Data driven testing using data tables with the where clause. 
 
## Examples

``` clojure
[eggplant.core :refer :all]

(defspec multiplying-two-numbers
  (specification
   {:given "a input of :a and :b"
    :when  "we #*"
    :then  "we expect :result"
    :data {:a 3 :b 4 :result 12}}))

(defspec change-a-string-to-uppercase
  (specification
   {:given "a input of :a"
    :when  "we #clojure.string/upper-case"
    :then  "we expect :result"
    :data {:a "hello" :result "HELLO"}}))

(defspec finding-the-max-of-two-numbers
  (specification
   {:expect "the #max of :a and :b"
    :where  {:a 2 :b 3 :expected 3}}))

```
## Contribute

Always looking for contribution so please reach out and take some of the issues or create new ones. Beginner friendly.
 
## Dependency

Available: [![Clojars Project](https://img.shields.io/clojars/v/eggplant.svg)](https://clojars.org/eggplant)

#### Leiningen/Boot
``` 
    [eggplant "0.2.0"]
```
#### Gradle  
```
    compile "eggplant:eggplant:0.2.0"
```
#### Maven  
```
    <dependency>
      <groupId>eggplant</groupId>
      <artifactId>eggplant</artifactId>
      <version>0.2.0</version>
    </dependency>
```
## Contributors

Many thanks to those who have contributed to Eggplant:

- Stuart Perks @perkss
- Dan Nicolici @dannicolici
 
## Thanks

Thanks to some key players in the Clojure space that makes this fun all possible: 
 
- Rich Hickey for [Clojure](http://clojure.org).
- Colin Fleming for [Cursive](https://cursiveclojure.com).
- Phil Hagelberg for [Leiningen](http://leiningen.org).
- Stuart Sierra, Chas Emerick, Allen Rohner, and Stuart Halloway for [Clojure Test](https://clojure.github.io/clojure/clojure.test-api.html).

