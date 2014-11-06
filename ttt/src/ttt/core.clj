(ns ttt.core
  (:require [ttt.controller :refer :all]
            [ttt.display    :refer :all]
            [ttt.board      :refer :all]))

(defn -main [& args]
  (start-game {}))

