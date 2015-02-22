# vim: et sw=2 ts=2 syntax=ruby
VERSION_NUMBER = "1.0.0"
GROUP = "gntp"
COPYRIGHT = ""

EXAMPLES = '*Example'

repositories.remote << "http://repo1.maven.org/maven2/"

desc "The GNTP project"
define "gntp" do
  project.version = VERSION_NUMBER  
  compile.with [
    'org.jboss.netty:netty:jar:3.2.7.Final',
    'com.google.guava:guava:jar:10.0.1',
    'log4j:log4j:jar:1.2.16' ]

  test.compile.with [
    'junit:junit:jar:4.10',
    'org.mockito:mockito-all:jar:1.9.0']

  test.exclude EXAMPLES

  package(:jar)
end

define "examples" do
  compile.with project('gntp').compile.dependencies
  test.compile.from 'src/test/examples'
  test.compile.with [ 
       project('gntp').compile.dependencies, 
       project('gntp').test.compile.dependencies ]
  test.include EXAMPLES
end
