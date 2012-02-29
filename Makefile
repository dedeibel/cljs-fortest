
all: fortest.js

fortest.js: fortest.cljs
	cljsc $< > $@

.PHONY: clj
clj:
	@echo "Please make sure clojure.jar is in CLASSPATH"
	java clojure.main fortest.clj
	
.PHONY: clean
clean:
	rm -f fortest.js
	rm -rf out
