// Load the SDK
var AWS = require('aws-sdk');

// Configure credentials
AWS.config.loadFromPath('./config.json');

// Create an S3 client
var s3 = new AWS.S3();

// Create a bucket and upload something into it
var bucketName = 'unique-bucket-name';
s3.createBucket({Bucket: bucketName}, function() {
  var params = {Bucket: bucketName, Key: 'myKey', Body: 'Hello!'};
  s3.putObject(params, function(err, data) {
    if (err)
      console.log(err)
    else
      console.log("Successfully uploaded data to " + bucketName + "/myKey");
  });
});
