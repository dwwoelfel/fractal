(ns fractal.fractalapp
  (:import [org.opensourcephysics.frames PlotFrame]
           [org.opensourcephysics.controls SimulationControl])
  (:gen-class
   :name "org.opensourcephysics.controls.FractalApp"
   :extends org.opensourcephysics.controls.AbstractSimulation))

(def frame (PlotFrame. "x" "y" "Hennon's Map"))

(def a [0.90, 0.26, 0.26, 0.00])
(def b [-0.01, 0.26,-0.26, 0.00])
(def c [0.01, -0.26, 0.26, 0.00])
(def d [0.90, 0.26, 0.26, 0.25])
(def e [0.00, 0.00, 0.00, 0.00])
(def f [0.90, 0.18, 0.15, 0.00])

(def last-point (atom [0.5 0.5]))

(defn reset []
  (.setPreferredMinMax frame -5 5 -1 10)
  (.setSize frame 600 600)
  (.setMaximumPoints frame 2 1000000000)
  (.setConnected frame false)
  (.setMarkerSize frame 2 0)
  (reset! last-point [0.5 0.5]))

(defn transform [[x y]]
  (let [rdn (rand)
        i (cond
           (< rdn 0.65) 0
           (< rdn 0.8) 1
           (< rdn 0.9) 2
           :else 3)]
    [(+ (* (a i) x) (* (b i) y) (e i))
     (+ (* (c i) x) (* (d i) y) (f i))]))
  
(defn doStep []
  (reset! last-point
          (reduce (fn [point n]
                    (let [[x y] (transform point)]
                      (when (> n 30)
                        (.append frame 2 x y))
                      [x y]))
                  @last-point (range 0 40000))))
  

(defn -main []
   (.createApp (FractalApp.)))
