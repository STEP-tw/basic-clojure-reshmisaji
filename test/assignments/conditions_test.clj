(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
    (is (= :infinite (informative-divide 3 0)))))

(deftest truthy-harishchandra
  (testing "truthy value"
    (is (= 3 (harishchandra 3))))
  (testing "true value"
    (is (true? (harishchandra true))))
  (testing "falsy value"
    (is (nil? (harishchandra false))))
  (testing "nil value"
    (is (nil? (harishchandra nil)))))

(deftest truthy-yudishtira
  (testing "truthy value"
    (is (= 3 (yudishtira 3))))
  (testing "true value"
    (is (true? (yudishtira true))))
  (testing "falsy value"
    (is (= :ashwathama (yudishtira false))))
  (testing "nil value"
    (is (= :ashwathama (yudishtira nil)))))

(deftest duplicate-first-element
  (testing "empty collection"
    (is (nil? (duplicate-first []))))
  (testing "collection with one element"
    (is (= [1 1] (duplicate-first [1]))))
  (testing "collection with multiple values"
    (is (= [1 1 2] (duplicate-first [1 2])))))

(deftest author-five-point-someone
  (testing "when second parameter is 5"
    (is (= :chetan-bhagat (five-point-someone 3 5))))
  (testing "when first parameter is 5"
    (is (= :satan-bhagat (five-point-someone 5 3))))
  (testing "when first parameter is greater than second"
    (is (= :greece (five-point-someone 3 2))))
  (testing "When second parameter is greater than first"
    (is (= :universe (five-point-someone 3 6)))))