Automated web tests using Serenity, Cucumber and Maven

################################
#Run the tests like this:
################################

Chrome : 
mvn clean verify

PhantomJS :
mvn clean verify -Dphantomjs.binary.path=src\test\resources\drivers\phantomjs.exe

################################
#To run a single test/scenario
################################

add the tag name name to scenario ex: @debug

mvn clean verify -Dcucumber.options="--tags @debug"


################################
#Reports:
################################

The reports will be generated in `target/myreport.html 


