This is an attempt to translate some exercises from the book [Introduction to Computer Simulation Methods](http://sip.clarku.edu/) from Java to Clojure.

Here is what I have done so far:

I packaged up the opensourcephysics source code and [submitted it to clojars](https://clojars.org/org.clojars.dwwoelfel/osp). The [source is on Github](https://github.com/dwwoelfel/opensourcephysics).

I translated the FractalApp.java file (found in the java directory) to Clojure.

Unfortunately, I'm stuck on a java.lang.ClassNotFoundException. I can't do lein compile without this error:

    Caused by: java.lang.ClassNotFoundException: org.opensourcephysics.controls.AbstractSimulation
            at java.net.URLClassLoader$1.run(Unknown Source)
            at java.net.URLClassLoader$1.run(Unknown Source)
            at java.security.AccessController.doPrivileged(Native Method)
            at java.net.URLClassLoader.findClass(Unknown Source)
            at clojure.lang.DynamicClassLoader.findClass(DynamicClassLoader.java:61)
            at java.lang.ClassLoader.loadClass(Unknown Source)
            at java.lang.ClassLoader.loadClass(Unknown Source)
            at java.lang.Class.forName0(Native Method)
            at java.lang.Class.forName(Unknown Source)
            at clojure.lang.RT.classForName(RT.java:2039)
            at clojure.core$the_class.invoke(genclass.clj:99)
            at clojure.core$generate_class.invoke(genclass.clj:119)
            at clojure.core$gen_class.doInvoke(genclass.clj:622)
            at clojure.lang.RestFn.invoke(RestFn.java:1124)
            at clojure.lang.Var.invoke(Var.java:465)
            at clojure.lang.AFn.applyToHelper(AFn.java:248)
            at clojure.lang.Var.applyTo(Var.java:532)
            at clojure.lang.Compiler.macroexpand1(Compiler.java:6366)
            at clojure.lang.Compiler.analyzeSeq(Compiler.java:6441)
            ... 45 more

It appears that I've declared dependencies incorrectly, or packaged up the opensourcephysics code incorrectly. Any help is appreciated.
