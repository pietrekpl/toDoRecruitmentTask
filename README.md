
![screen1](https://github.com/pietrekpl/toDoRecruitmentTask/assets/45723159/3137c4e0-99ad-4fef-b979-f4f12a190c58)


**Recruitment task : To do app**
* App made with Java, Spring Boot, PostreSQL, and Angular
* To run the app please clone repository, override credentials for Database username and password of your own.
* Base url to test requests is : http://localhost:8080/api/tasks
* Using Post method you can pass body in json format
*  {
    "taskName": "buy milk",
    "deadline": "24.06.2023"  
}
* Empty taskname or deadline with backwards date won't be accepted for storing in Database
* To retrieve single task you may use path with Get method http://localhost:8080/api/tasks/1   where 1 is example of task id. 
* If id does not exists, app wil throw 404 NOT_FOND error status.
* To get List of all task you may use Get method with path : http://localhost:8080/api/tasks
* You can also pass parametres to filter and search your specific results, for example http://localhost:8080/api/tasks?taskName=read&sortBy=deadline&sortDirection=DESC
* PARAMS : taskName = task you are searching for, sortBy = you may choose between taskName, deadline, or status, sortDirection = ASC or DESC
* To update task you can use PUT method and path http://localhost:8080/api/tasks/1   where 1 is example of existing task id. You also should pass body in json to update the resource
* To delete the resource you can use DELETE method and path http://localhost:8080/api/tasks/1 where 1 is example of existing task id.
* To find out how many requests were made you can go to : http://localhost:8080/api/tasks/counter
* Tu use frontend side of app, head for path of your app  : <YOUR_PATH>/frontend/frontend-app
* Then type in that direction : npm install and then ng serve. App will be available under :http://localhost:4200


