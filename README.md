## API

- Delete Upcoming Match
```sh
Request Type: delete
API: http://<<URL>>/api/match/deleteUpcomingMatch
```
- Get all the winner Team name
```sh
Request Type: get
API: http://<<URL>>/api/match/getAllWinnerTeam
```
- Get all the team names and team id-s
```sh
Request Type: get
API: http://<<URL>>/api/match/getAllTeamWithTeamId
```
- Get all upcoming matches by team id
```sh
Request Type: get
API: http://<<URL>>/api/match/getAllUpcomingMatchWithTeamId
```
- Get all matches by team id
```sh
Request Type: get
API: http://<<URL>>/api/match/getAllMatchWithTeamId
```
- Update start date of match
```sh
Request Type: put
API: http://<<URL>>/api/match/updateStartDate/{id}
JSON Request Body: { "startDate": "19/12/1989" }
```
- Update team name
```sh
Request Type: put
API: http://<<URL>>/api/match/updateTeamName/{id}
JSON Request Body: { "homeTeam": "NewTeamName", "awayTeam": "NewTeamName" }
```

## Thank you...!!!