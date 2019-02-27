Feature: verify data 
Scenario Outline: test file type name
When Chriss-Mac-Pro% java InputValidationSolution test
Then Your filename is "<Filename>" type.
Examples:
|Filename    | 
|test        |           
|test; ls -la| 
|fdf| 
| \n     | 
       