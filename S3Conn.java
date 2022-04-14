
import java.io.IOException;

import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


public class S3Conn {
	public static void main(String args[]) throws IOException {
	try {

	   AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
			 List<Bucket> bucketList = null;
			 System.out.println(bucketList);
			 bucketList = s3Client.listBuckets();
			 //s3Client.listObjects("s3bucketjava1");
			 if(bucketList!=null)
			 {
			 System.out.print("S3 Connectivity object Created");
			 System.out.println(bucketList);
			 }
		}
	catch(Exception e) {
			System.out.print(e.getMessage());
		}
}
}

//aws-java-sdk-core-1.12.1.jar
//aws-java-sdk-s3-1.12.1.jar
//commons-logging-1.1.3.jar
//httpclient-4.5.13.jar
//httpcore-4.4.13.jar
//jackson-annotations-2.12.3.jar
//jackson-core-2.12.3.jar
//jackson-databind-2.12.3.jar
//joda-time-2.8.1.jar


