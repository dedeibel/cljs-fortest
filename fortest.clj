(ns fortest)

(defn out [& msgs]
  (println (apply str msgs)))

(defn oknok [bool]
  (if bool "ok" "nok"))

(defn init []
  (out "Hello world")
  (out "Test1: "
    (oknok
      (= [[0 1] [1 0] [1 1]]
         (for [a [0 1] b [0 1]
           :when (not (and (= 0 a) (= 0 b)))]
           [a b]))))
  (out "Test2: "
    (oknok
      (= [[0 1] [1 0] [1 1]]
         (for [a [0 1] b [0 1]
           :when (not (= 0 a b))]
           [a b])))))

(init)
