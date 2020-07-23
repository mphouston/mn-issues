Example for Null Foreign Reference on update with UUID and Postgres.  micronaut-data issue: 671

Also has demonstration code for issue with JSON Codec saving JSON with enclosing quotes.  micronaut-data issue: 672

Requires a Postgres database (micronaut-test on localhost).   See application.yml for connection details.

To demonstrate test, run: _./gradlew test_ 

The test _RefIssueTest_ demonstrates the issue https://github.com/micronaut-projects/micronaut-data/issues/671

The test _JsonColumnIssueTest_ demonstrates the issue https://github.com/micronaut-projects/micronaut-data/issues/672


