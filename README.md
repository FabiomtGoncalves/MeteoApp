```
SpringToolSuite4
JAVA
Thymeleaf
MySQL
```   

| REQUEST | API URL                                                                                           |
|  :---:  |:-------------------------------------------------------------------------------------------------:|
| GET     | https://www.el-tiempo.net/api/json/v2/provincias                                                  |
| GET     | https://www.el-tiempo.net/api/json/v2/provincias/[COD_PROV]/municipios                            |
| GET     | https://www.el-tiempo.net/api/json/v2/provincias/[COD_PROV]/municipios/[first_5_INE_code_numbers] |

### Requirements
| ID      | Name                                                | Requirements
| :-----: | :-------------------------------------------------: | :-------------------------------------------------:
| REQF01  | Current Day                                         | The current, maximum and minimum temperature. <br /> • The day that we are; <br /> • The name of the municipality <br /> • The probability of rain (devided into hourly quarters)        |
| REQF02  | Next N days                                         | The number of the day. <br /> • Maximum temperature <br /> • Minimum temperature <br /> • The probability of rain (as the highest probability of all day)                                 |
| REQF03  | Municipality Nested Search                          | The user can search for municipalities based on a nested search of: <br /> • Communities <br /> • Provinces <br /> • Municipalities                                                  |
| REQF04  | Meteorological Detail                               | • On this list, you will click on the desired municipality and the weather information will appear. |
| REQF05  | User Registration                                   | • Users must be registered in the application to be able to use it. <br /> • The Login system is indifferent, although it is recommended to use an IDP such as Keyclock.               |
| REQF06  | Save Favorite Municipality                          | • A user can save a municipality as a favorite. |
| REQF07  | List Favorite Municipalities                        | • A user will be able to access their favorite municipalities directly and see the weather for each of them. |
| REQF08  | Consulation of communities/provinces/municipalities | • Queries to communities, municipalities, provinces and time do not require authentication since the company may decide to make the APIs public in the future.                          |
| REQNF01 | Favorites storage                                   | • It is not necessary that when a user saves their favorite municipalities, they are saved immediately. It is not vital for the application and will allow efficient use of the Database which is overloaded with multiple requests and has slot response times. |
| REQNF02 | CI/CD                                               | • The product should be automatically deployed in the Cloud through Jenkins. |
| REQNF03 | Testing                                             | • Backend testing coverage must be greater than 80% |
