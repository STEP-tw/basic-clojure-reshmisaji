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

(deftest repeat-and-truncate-test
  (testing "when collection is empty"
    (is (= '() (repeat-and-truncate [] true true 3))))
  (testing "when collection is non empty"
    (is (= '(0 1 2 3 0 1) (repeat-and-truncate (range 4) true true 6))))
  (testing "when collection is non empty but not repeating"
    (is (= '(0 1 2 3) (repeat-and-truncate (range 4) false true 6))))
  (testing "when collection is non empty but not truncating"
    (is (= '(0 1 2 3 0 1 2 3) (repeat-and-truncate (range 4) true false 6))))
  (testing "when collection is non empty but not truncating and non repeating"
    (is (= '(0 1 2 3) (repeat-and-truncate (range 4) false false 6)))))

(deftest order-in-words-test
  (testing "when the first element is greater"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "when the third element is greater"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "when the third element is greater and they are in order"
    (is (= [:z-greater-than-x] (order-in-words 2 3 4)))))

(deftest zero-aliases-test
  (testing "When zero is given"
    (is (= :zero (zero-aliases 0))))
  (testing "When [] is given"
    (is (= :empty (zero-aliases []))))
  (testing "When () is given"
    (is (= :empty (zero-aliases ()))))
  (testing "When " " is given"
           (is (= :empty-string (zero-aliases ""))))
  (testing "When #{} is given"
    (is (= :empty-set (zero-aliases #{}))))
  (testing "When {} is given"
    (is (= :empty-map (zero-aliases {}))))
  (testing "When 1 is given"
    (is (= :not-zero (zero-aliases 1)))))