| REQUEST | API URL                                                                                           |
|  :---:  |:-------------------------------------------------------------------------------------------------:|
| GET     | https://www.el-tiempo.net/api/json/v2/provincias                                                  |
| GET     | https://www.el-tiempo.net/api/json/v2/provincias/[COD_PROV]/municipios                            |
| GET     | https://www.el-tiempo.net/api/json/v2/provincias/[COD_PROV]/municipios/[first_5_INE_code_numbers] |

### Requirements
| ID      | Name                                                | Requirements
| :-----: | :-------------------------------------------------: | :-------------------------------------------------:
| REQF01  | Current Day                                         | The current, maximum and minimum temperature. <br />  - The day that we are; <br />  - The name of the municipality <br />  - The probability of rain (devided into hourly quarters)
| REQF02  | Next N days                                         |
| REQF03  | Municipality Nested Search                          |
| REQF04  | Meteorological Detail                               |
| REQF05  | User Registration                                   |
| REQF06  | Save Favorite Municipality                          |
| REQF07  | List Favorite Municipalities                        |
| REQF08  | Consulation of communities/provinces/municipalities |
| REQNF01 | Favorites storage                                   |
| REQNF02 | CI/CD                                               |
| REQNF03 | Testing                                             |
