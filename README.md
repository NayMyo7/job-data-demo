# Job Data API
The Job Data API provides information about job listings. You can use this API to search for jobs based on job title, salary, gender, and other criteria.

##### Endpoint
`GET job-data?jobTitle[like]=developer&salary[gt]=12000&gender=male&page=1&size=10&fields=jobTitle, gender, salary&sort=salary,desc&sort=jobTitle,asc`

### Query Parameters
| No    | Parameter         | Description                                                               | Optional |
| :---: |    :---           |          :---                                                             |   :---:  |
| 1     | jobTitle[like]    | A partial match search for job titles containing the specified string.    |    Yes   |
| 2     | salary[gt]        | Show only jobs where the salary is greater than the specified value.      |    Yes   |
| 3     | gender            | Show only jobs where the gender matches the specified value.              |    Yes   |
| 4     | page              | The page number to display. Defaults to 1.                                |    Yes   |
| 5     | size              | The number of items to display per page. Defaults to 10.                  |    Yes   |
| 6     | fields            | A comma-separated list of fields to include in the response.              |    Yes   |
| 7     | sort              | A comma-separated list of fields to sort the results by. Use the format <field name>,<asc/desc> to specify the sort direction. Multiple sort fields can be specified. |    Yes   |

### Example Request
`curl --location 'localhost:8080/job-data?jobTitle%255Blike%255D=developer&salary%255Bgt%255D=12000&gender=male&page=1&size=10&fields=jobTitle%2C%20gender%2C%20salary&sort=salary%2Cdesc&sort=jobTitle%2Casc'`

This example request searches for jobs with a job title containing the string "developer", where the salary is greater than 12000, and where the gender is male. The results are sorted by salary in descending order and then by job title in ascending order. The response includes the jobTitle, gender, and salary fields for each job, and displays 10 items per page on page number 1.

### Example Response
`{
     "status": "success",
     "message": "Job data has been successfully retrieved.",
     "data": {
         "content": [
             {
                 "Job Title": "Web developer",
                 "Salary": 700000,
                 "Gender": "Male"
             },
             {
                 "Job Title": "Senior developer",
                 "Salary": 300000,
                 "Gender": "Male"
             },
             {
                 "Job Title": "Full stack web developer",
                 "Salary": 182000,
                 "Gender": "Male"
             },
             {
                 "Job Title": "Sr front-end developer",
                 "Salary": 160000,
                 "Gender": "Male"
             },
             {
                 "Job Title": "Web developer",
                 "Salary": 160000,
                 "Gender": "Male"
             },
             {
                 "Job Title": "senior developer",
                 "Salary": 145000,
                 "Gender": "Male"
             },
             {
                 "Job Title": "Full stack web developer",
                 "Salary": 140000,
                 "Gender": "Male"
             },
             {
                 "Job Title": "Rails developer",
                 "Salary": 140000,
                 "Gender": "Male"
             },
             {
                 "Job Title": "software developer",
                 "Salary": 139000,
                 "Gender": "Male"
             },
             {
                 "Job Title": "Senior Front-end/Full-stack developer",
                 "Salary": 135000,
                 "Gender": "Male"
             }
         ],
         "pageNumber": 1,
         "pageSize": 10,
         "totalElements": 96,
         "totalPages": 10
     }
 }`
 
 This example response shows a list of job data that matches the specified filters and pagination options. The response includes the jobTitle, gender, and salary fields for each job, sorted by salary in descending order and then by job title in ascending order.