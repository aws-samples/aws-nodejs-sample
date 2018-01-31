/*
 * Copyright 2013. Amazon Web Services, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

// Load the SDK
var AWS = require('aws-sdk');

// Create an S3 client
var s3 = new AWS.S3();

var bucketName = 'node.sdk.sample.bucket';
var keyName = 'hello_world.txt';
var lastModified = new Date().toString();

// Check if bucket exists or create a new one
s3.headBucket({ Bucket: bucketName }, function(errResponse, requestResponse) {
    var params = { Bucket: bucketName, Key: keyName, Body: 'Hello World! ' + lastModified };
    if (errResponse) {
        console.log("Create new bucket before upload");
        s3.createBucket({ Bucket: bucketName }, function() {
            s3.putObject(params, uploadFileCallback);
        });
    } else {
        console.log("Bucket already exists, continue with upload");
        s3.putObject(params, uploadFileCallback);
    }
});

// Response handler
function uploadFileCallback(err, data) {
    if (err)
        console.log(err)
    else
        console.log("Successfully uploaded data to " + bucketName + "/" + keyName);
}