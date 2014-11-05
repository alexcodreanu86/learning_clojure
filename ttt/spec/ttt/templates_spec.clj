(ns ttt.templates-spec
  (:require [speclj.core :refer :all]
            [ttt.templates :refer :all]))
(describe "render-board"
  (it "renders the board"
    (def board {0 "X" 2 "O" 4 "X" 8 "O"})
     (should= "X| |O\n-----\n |X| \n-----\n | |O"
               (render-board board))))
