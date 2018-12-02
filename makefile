EXE	:= myBackoff
JFLAGS	:= -g
JCC	:= javac

all: $(EXE)

$(EXE): $(EXE).java
	$(JCC) $(JFLAGS) $(EXE).java

clean:
	$(RM) *.class

zip:
	@zip jtn136-tkm129-rs1515-PA3.zip *.java makefile
