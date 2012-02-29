(ns fortest)

(defn out [& msgs]
  (.log js/console (apply str msgs)))

(defn oknok [bool]
  (if bool "ok" "nok"))

(defn print-list [l]
  (doseq [touple l]
    (out (apply str (interpose ", " touple)))))

(defn ^:export init []
  (out "Hello world")
  (let [content (for [a [0 1] b [0 1]
         :when (not (and (= 0 a) (= 0 b)))]
         [a b])]
    (out "Test1: "
      (oknok
        (= [[0 1] [1 0] [1 1]]
           content))))
  (let [content (for [a [0 1] b [0 1]
         :when (not (= 0 a b))]
         [a b])]
    (out "Test2: "
      (oknok
        (= [[0 1] [1 0] [1 1]]
           content)))
    (out "Test 2 Content:")
    (print-list content)))

