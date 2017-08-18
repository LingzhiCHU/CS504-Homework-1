# CS504-Homework-1

1.git clone (dir)

2.compile in terminal: mvn clean install

3.run: java -jar (name of .jar file)

4.open postman and enter HTTP request

  a.insert(POST Request): http://localhost:8080/running
  
  b.findAll(GET Request):Ex: http://localhost:8080/find/sort?page=2&size=2 (page and size doest not matter)
  
  c.deleterByRunningId(DELETE Request):Ex:http://localhost:8080/purge/runningId/28810a26-25e6-4680-8baf-59bb07c4aee0(runningId)
