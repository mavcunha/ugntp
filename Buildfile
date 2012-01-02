#vim: et sw=2 ts=2 syntax=ruby
VERSION_NUMBER = "1.0.0"
GROUP = "gntp"
COPYRIGHT = ""

repositories.remote << "http://repo1.maven.org/maven2/"

desc "The GNTP project"
define "gntp" do
  project.version = VERSION_NUMBER  
  compile.with [
    'junit:junit:jar:4.10',
    'org.jboss.netty:netty:jar:3.2.7.Final',
    'org.mockito:mockito-all:jar:1.9.0',
    'com.google.guava:guava:jar:10.0.1']
  test.exclude '*Integration'
end

define "integrate" do
  test.compile.from 'src/test/integration'
  test.compile.with project('gntp').compile.dependencies
  test.include '*Integration'
  test.using :integration  
end
