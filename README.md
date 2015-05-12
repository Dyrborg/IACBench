# IACBench

| TestCase | AppName  | Description |
| -------- | ------------- | ------------- |
| 1 | ActToAct  | In this test case, an implicit Intent is send from one Activity to another Activity via the startActivity() method. |
| 2 | ActToService | In this test case an implicit Intent is send from a Activity to a Service, via the startService() method |
| 3 | ActToBndService  | In this test case an implicit Intent is send from a Activity to a Service, via the bindService() method. |
| 4 | ActToBroad  | In this test case an implicit Intent is send from a Activity to a Broadcast Reciever, via the sendBroadcast() method. |
| 5 | ActToOrdBroad  | In this test case an implicit Intent is send from a Activity to a Broadcast Reciever, via the sendOrderedBroadcast method. |
| 6 | MultipleIntents | In this test case, multiple implicit Intents with the same action, category and mime-type will be sent from one component to another, with the exact same source and the exact same sink. This test case will test a tools ability to recognize that these flows are the same and should not be treated as being different from each other. |
| 7 | LoopApp  | In this test case, an Intent is sent from one component to another, however the component sending the intent can also receive that intent and thus creates a loop. This test case is designed to test a tools ability to detect and handle loops. |
| 8 | LongChain  | In this test case an intent is sent from one component to another, several times, creating a communication chain that involves five intents. This test case is designed to test a tools ability to handle flows that involve several intents, in succession. |
| 9 | SameFilterDiffComp  | In this test case the same intent is sent to three different components -- an Activity, a Service and a BroadcastReceiver. This test case is designed to test a tools ability to differentiate the three intents and map them to the correct component. |

| TestCase | Succes Criteria |
| -------- | ---------------- |
| 1 | Find a flow from getDeviceId() to Log.i() through the app ActToAct. | 
| 2 | Find a flow from getDeviceId() to Log.i() through the app ActToService. |
| 3 | Find a flow from getDeviceId() to Log.i() through the app ActToBndServ. |
| 4 | Find a flow from getDeviceId() to Log.i() through the app ActToBroad. |
| 5 | Find a flow from getDeviceId() to Log.i() through the app ActToOrdBroad. |
| 6 | Find a flow from getDeviceId() to Log.i() through the app MultipleIntents. |
| 7 | Find a flow from getDeviceId() to Log.i() through the app LoopApp. |
| 8 | Find a flow from getDeviceId() to Log.i() through the app LongChain. |
| 9 | Find three flows from getDeviceId() to Log.i() through the app SameFilterDiffComp. |
