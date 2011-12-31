#vim: et sw=2 ts=2
VERSION_NUMBER = "1.0.0"
GROUP = "gntp"
COPYRIGHT = ""

repositories.remote << "http://repo1.maven.org/maven2/"
desc "The GNTP project"

define "gntp" do
  project.version = VERSION_NUMBER  
  compile.with 'junit:junit:jar:4.10'
  test.exclude '*Integration'
end

define "integrate" do
  test.compile.from 'src/test/integration'
  test.compile.with project('gntp').compile.dependencies
  test.include '*Integration'
  test.using :integration  
end
