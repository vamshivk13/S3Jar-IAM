
import java.io.IOException;

import java.util.List;

import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


public class S3ConnEc2Only {
	public static void main(String args[]) throws IOException {
	try {
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	              .withCredentials(new InstanceProfileCredentialsProvider(false))
	              .build();
	 //  AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
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



