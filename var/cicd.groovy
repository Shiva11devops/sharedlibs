def download(repo)
{
  git "https://github.com/Shiva11devops/${repo}"
}
def build()
{
  sh 'mvn package'
}
def deploy(jobname,ip,path)
{
  sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${path}.war"
}
def runtest(jobname,path)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/${path}.war"
}
