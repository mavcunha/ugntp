# Unfinished GNTP Java Implementation

This is a simple implementation of
[GNTP](http://growl.info/documentation/developer/gntp.php "Growl Notification
Transport Protocol") that I started as a pet project when I discoved that
IntelliJ doesn't use this protocol only the `NSDistributedNotificationCenter`. 

As for new Growl installations (I think from version 1.3.0) on the Mac it
doesn't support the `NSDistributedNotificationCenter` anymore only the GNTP, so
IntelliJ can't send notifications through Growl.

## What's implemented

For now these are implemented (only required attributes):

* Send register message to Growl
* Send notify message to Growl

## Usage

### Register an application and send a notification

	public class GrowlGNTP {
	  public static void main(String[] args) {
	    Application application = new Application("My Application");
	    Notification notification = new Notification("My Notification");
	    Notifications notifications = new Notifications(notification);

	    Growl growl = new Growl(application);
	    growl.register(notifications);
	    growl.notify(notification);
	  }
	}
