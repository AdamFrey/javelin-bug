(ns javelin-bug.core
  (:require [javelin.core :as j]))

(enable-console-print!)

(j/defc x 1)

(j/defc= computed-working
  (let [inner-binding "huh"]
    (and x inner-binding)))

(j/mx
  '(j/defc= computed-working
     (let [inner-binding "huh"]
       (and x inner-binding))))

;; NOT WORKING
;; Warning: Use of undeclared Var namespace/inner-binding

#_(j/defc= computed-not-working
    (let [inner-binding "huh"]
      (and inner-binding x)))

(j/mx
  '(j/defc= computed-not-working
     (let [inner-binding "huh"]
       (and inner-binding x))))
