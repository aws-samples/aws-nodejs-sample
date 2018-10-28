# AWS SDK for Node.js - CloudWatchLog Sample Project

1. simple Node.js - Simple application to upload Hello_world file to Amzon S3
2. cloudwatchlog.js - Application which can retrive log groups and events from AWS CloudWatchLogs
3. cloudwatchlog_filer.js - Application which can retive log based on filters from AWS CloudWatchLogs

## Requirements

The only requirement of this application is the Node Package Manager. All other
dependencies (including the AWS SDK for Node.js) can be installed with:

    npm install

## Basic Configuration

You need to set up your AWS security credentials before the sample code is able
to connect to AWS. You can do this by creating a file named "credentials" at ~/.aws/ 
(C:\Users\USER_NAME\.aws\ for Windows users) and saving the following lines in the file:

    [default]
    aws_access_key_id = <your access key id>
    aws_secret_access_key = <your secret key>

## Config - For CloudWatchLog Application

You need to set up your AWS security credentials before the cloudwatchlog code is able
to connect to AWS. You can do this by creating a file named "config.json" and saving the following lines in the file:

    { 
	"accessKeyId": "you_access_key>, 
	"secretAccessKey": <your_secret_access_key>, 
	"region": <required_region> 
    }
    
See the [Security Credentials](http://aws.amazon.com/security-credentials) page.
It's also possible to configure your credentials via a configuration file or
directly in source. See the AWS SDK for Node.js [Developer Guide](http://docs.aws.amazon.com/AWSJavaScriptSDK/guide/node-configuring.html)
for more information.

## Running the application sample

This sample application connects to Amazon's [Simple Storage Service (S3)](http://aws.amazon.com/s3),
creates a bucket, and uploads a file to that bucket. The script will automatically
create the file to upload. All you need to do is run it:

    node sample.js

This cloudwatchlog application connects to Amazon's CloudWatchLog,and
retive the Log Groups, Log Streams, and Log Events for Filters from there.  All you need to do is run it:

    node cloudwatchlogs.js
    node cloudwatchlogs_filter.js
    
The S3 documentation has a good overview of the [restrictions for bucket names](http://docs.aws.amazon.com/AmazonS3/latest/dev/BucketRestrictions.html)
for when you start making your own buckets.

## License

This sample application is distributed under the
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

