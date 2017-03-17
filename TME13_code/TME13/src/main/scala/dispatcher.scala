
package upmc.akka.culto

import akka.actor.Actor.Receive

import math._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

//Question 1
abstract class ObjetMusical
case class Note (pitch:Int, vol:Int, dur:Int) extends ObjetMusical
case class Chord (date:Int, notes:List[Note]) extends ObjetMusical
case class Chordseq (chords:List[Chord]) extends ObjetMusical
case class Voix (id:Int, chords:List[Chord]) extends ObjetMusical
case class MidiNote (pitch:Int, vel:Int, dur:Int, at:Int)

case class PlayVoice(num : Int, chords:List[Chord])
case class PlayNormal(chordseq:Chordseq)

/* MAIN */
object PlayCantate extends App {
  val system = ActorSystem("VoicerSystem")
  val PlayerActor = system.actorOf(Props[PlayerActor], name = "Player")

  //Question 1
    val cantate = Chordseq ( List (Chord (0 , List (Note (45, 100, 4000), Note (60, 100, 2000), Note (64, 100, 4000), Note (57, 100, 2000)))
      , Chord (2000 , List (Note (62, 100, 2000), Note (59, 100, 2000)))
      , Chord (4000 , List (Note (57, 100, 1000), Note (64, 100, 1000), Note (69, 100, 1000), Note (60, 100, 1000)))
      , Chord (5000 , List (Note (56, 100, 1000), Note (64, 100, 1000), Note (71, 100, 1000), Note (59, 100, 1000)))
      , Chord (6000 , List (Note (57, 100, 500), Note (64, 100, 1000), Note (72, 100, 1000), Note (57, 100, 1000)))
      , Chord (6500 , List (Note (55, 100, 500)))
      , Chord (7000 , List (Note (54, 100, 1000), Note (62, 100, 1000), Note (74, 100, 1000), Note (57, 100, 1000)))
      , Chord (8000 , List (Note (55, 100, 1000), Note (62, 100, 500), Note (71, 100, 1500), Note (59, 100, 2000)))
      , Chord (8500 , List (Note (64, 100, 500)))
      , Chord (9000 , List (Note (51, 100, 1000), Note (66, 100, 1000)))
      , Chord (9500 , List (Note (69, 100, 500)))
      , Chord (10000 , List (Note (52, 100, 1000), Note (64, 100, 1000), Note (67, 100, 1000), Note (59, 100, 1000)))
      , Chord (11000 , List (Note (48, 100, 1000), Note (64, 100, 1000), Note (67, 100, 1000), Note (60, 100, 1000)))
      , Chord (12000 , List (Note (53, 100, 1000), Note (64, 100, 1000), Note (69, 100, 1000), Note (60, 100, 500)))
      , Chord (12500 , List (Note (59, 100, 500)))
      , Chord (13000 , List (Note (54, 100, 1000), Note (62, 100, 1000), Note (69, 100, 1000), Note (57, 100, 1000)))
      , Chord (14000 , List (Note (55, 100, 1000), Note (62, 100, 500), Note (71, 100, 1000), Note (55, 100, 500)))
      , Chord (14500 , List (Note (65, 100, 500), Note (57, 100, 500)))
      , Chord (15000 , List (Note (56, 100, 1000), Note (64, 100, 500), Note (71, 100, 1000), Note (59, 100, 1000)))
      , Chord (15500 , List (Note (62, 100, 500)))
      , Chord (16000 , List (Note (57, 100, 3000), Note (60, 100, 3000), Note (64, 100, 3000), Note (57, 100, 3000)))
      , Chord (19000 , List (Note (52, 100, 500), Note (59, 100, 1000), Note (64, 100, 1000), Note (56, 100, 1000)))
      , Chord (19500 , List (Note (50, 100, 500)))
      , Chord (20000 , List (Note (48, 100, 1000), Note (64, 100, 1000), Note (69, 100, 1000), Note (57, 100, 1000)))
      , Chord (21000 , List (Note (47, 100, 1000), Note (66, 100, 500), Note (71, 100, 1000), Note (62, 100, 1000)))
      , Chord (21500 , List (Note (68, 100, 500)))
      , Chord (22000 , List (Note (45, 100, 500), Note (69, 100, 1000), Note (72, 100, 1000), Note (64, 100, 1000)))
      , Chord (22500 , List (Note (55, 100, 500)))
      , Chord (23000 , List (Note (53, 100, 500), Note (69, 100, 500), Note (74, 100, 500), Note (57, 100, 1000)))
      , Chord (23500 , List (Note (52, 100, 500), Note (67, 100, 500), Note (72, 100, 500)))
      , Chord (24000 , List (Note (50, 100, 500), Note (65, 100, 500), Note (71, 100, 1500), Note (57, 100, 500)))
      , Chord (24500 , List (Note (52, 100, 500), Note (64, 100, 500), Note (56, 100, 500)))
      , Chord (25000 , List (Note (53, 100, 1000), Note (62, 100, 1000), Note (57, 100, 1000)))
      , Chord (25500 , List (Note (69, 100, 500)))
      , Chord (26000 , List (Note (52, 100, 1000), Note (64, 100, 1000), Note (67, 100, 1000), Note (59, 100, 1000)))
      , Chord (27000 , List (Note (47, 100, 1000), Note (62, 100, 1000), Note (67, 100, 1000), Note (59, 100, 1000)))
      , Chord (28000 , List (Note (48, 100, 1000), Note (64, 100, 1000), Note (69, 100, 1000), Note (57, 100, 500)))
      , Chord (28500 , List (Note (59, 100, 500)))
      , Chord (29000 , List (Note (49, 100, 1000), Note (64, 100, 1000), Note (69, 100, 1000), Note (57, 100, 500)))
      , Chord (29500 , List (Note (55, 100, 500)))
      , Chord (30000 , List (Note (50, 100, 1000), Note (62, 100, 500), Note (71, 100, 1000), Note (54, 100, 500)))
      , Chord (30500 , List (Note (64, 100, 500), Note (55, 100, 500)))
      , Chord (31000 , List (Note (51, 100, 1000), Note (66, 100, 1000), Note (71, 100, 1000), Note (57, 100, 1000)))
      , Chord (32000 , List (Note (52, 100, 3000), Note (59, 100, 3000), Note (64, 100, 3000), Note (56, 100, 3000)))
      , Chord (35000 , List (Note (57, 100, 500), Note (60, 100, 1000), Note (76, 100, 1000), Note (57, 100, 1000)))
      , Chord (35500 , List (Note (55, 100, 500)))
      , Chord (36000 , List (Note (53, 100, 1000), Note (69, 100, 1000), Note (74, 100, 1000), Note (57, 100, 1000)))
      , Chord (37000 , List (Note (54, 100, 1000), Note (69, 100, 1000), Note (72, 100, 1000), Note (62, 100, 1000)))
      , Chord (38000 , List (Note (55, 100, 1000), Note (67, 100, 1000), Note (72, 100, 1000), Note (62, 100, 500)))
      , Chord (38500 , List (Note (64, 100, 500)))
      , Chord (39000 , List (Note (43, 100, 1000), Note (67, 100, 1000), Note (71, 100, 1000), Note (65, 100, 500)))
      , Chord (39500 , List (Note (62, 100, 500)))
      , Chord (40000 , List (Note (48, 100, 3000), Note (67, 100, 3000), Note (72, 100, 3000), Note (64, 100, 3000)))
      , Chord (43000 , List (Note (55, 100, 1000), Note (67, 100, 500), Note (71, 100, 1000), Note (62, 100, 1000)))
      , Chord (43500 , List (Note (65, 100, 500)))
      , Chord (44000 , List (Note (57, 100, 1000), Note (64, 100, 1000), Note (72, 100, 1000), Note (60, 100, 1000)))
      , Chord (45000 , List (Note (59, 100, 1000), Note (62, 100, 1000), Note (74, 100, 1000), Note (67, 100, 1000)))
      , Chord (46000 , List (Note (60, 100, 500), Note (60, 100, 1000), Note (76, 100, 1000), Note (67, 100, 1000)))
      , Chord (46500 , List (Note (59, 100, 500)))
      , Chord (47000 , List (Note (57, 100, 500), Note (64, 100, 1000), Note (76, 100, 1000), Note (60, 100, 500)))
      , Chord (47500 , List (Note (55, 100, 500), Note (59, 100, 500)))
      , Chord (48000 , List (Note (54, 100, 500), Note (69, 100, 500), Note (74, 100, 1500), Note (57, 100, 1000)))
      , Chord (48500 , List (Note (52, 100, 500), Note (67, 100, 500)))
      , Chord (49000 , List (Note (54, 100, 500), Note (69, 100, 500), Note (62, 100, 1000)))
      , Chord (49500 , List (Note (50, 100, 500), Note (66, 100, 500), Note (72, 100, 500)))
      , Chord (50000 , List (Note (55, 100, 1000), Note (67, 100, 1000), Note (71, 100, 1000), Note (62, 100, 1000)))
      , Chord (51000 , List (Note (55, 100, 500), Note (67, 100, 1000), Note (71, 100, 1000), Note (62, 100, 1000)))
      , Chord (51500 , List (Note (53, 100, 500)))
      , Chord (52000 , List (Note (52, 100, 500), Note (67, 100, 500), Note (72, 100, 1000), Note (55, 100, 1000)))
      , Chord (52500 , List (Note (50, 100, 500), Note (65, 100, 500)))
      , Chord (53000 , List (Note (52, 100, 500), Note (67, 100, 500), Note (71, 100, 1000), Note (60, 100, 1000)))
      , Chord (53500 , List (Note (48, 100, 500), Note (64, 100, 500)))
      , Chord (54000 , List (Note (53, 100, 500), Note (60, 100, 1000), Note (69, 100, 1000), Note (60, 100, 500)))
      , Chord (54500 , List (Note (55, 100, 500), Note (59, 100, 500)))
      , Chord (55000 , List (Note (53, 100, 500), Note (60, 100, 1000), Note (69, 100, 1000), Note (57, 100, 500)))
      , Chord (55500 , List (Note (52, 100, 500), Note (55, 100, 500)))
      , Chord (56000 , List (Note (51, 100, 500), Note (59, 100, 500), Note (71, 100, 1500), Note (54, 100, 500)))
      , Chord (56500 , List (Note (52, 100, 500), Note (61, 100, 500), Note (55, 100, 500)))
      , Chord (57000 , List (Note (54, 100, 1000), Note (63, 100, 1000), Note (57, 100, 1000)))
      , Chord (57500 , List (Note (69, 100, 500)))
      , Chord (58000 , List (Note (52, 100, 1000), Note (64, 100, 1000), Note (67, 100, 1000), Note (59, 100, 1000)))
      , Chord (59000 , List (Note (47, 100, 1000), Note (62, 100, 1000), Note (67, 100, 500), Note (55, 100, 1000)))
      , Chord (59500 , List (Note (65, 100, 500)))
      , Chord (60000 , List (Note (48, 100, 1000), Note (62, 100, 500), Note (64, 100, 1000), Note (55, 100, 1000)))
      , Chord (60500 , List (Note (60, 100, 500)))
      , Chord (61000 , List (Note (53, 100, 1000), Note (60, 100, 500), Note (69, 100, 1000), Note (57, 100, 500)))
      , Chord (61500 , List (Note (62, 100, 500), Note (59, 100, 500)))
      , Chord (62000 , List (Note (52, 100, 500), Note (64, 100, 500), Note (69, 100, 500), Note (60, 100, 500)))
      , Chord (62500 , List (Note (50, 100, 500), Note (65, 100, 500), Note (71, 100, 500), Note (62, 100, 500)))
      , Chord (63000 , List (Note (52, 100, 500), Note (64, 100, 1000), Note (68, 100, 1000), Note (59, 100, 1000)))
      , Chord (63500 , List (Note (40, 100, 500)))
      , Chord (64000 , List (Note (45, 100, 4000), Note (64, 100, 4000), Note (69, 100, 4000), Note (61, 100, 4000)))
    ));

//  val cantate =
//    Chordseq ( List (
//      Chord (0 , List (Note (61, 100, 1000), Note (64, 100, 1000),
//        Note (64, 100, 1000), Note (69, 100, 1000)))
//      , Chord (1000 , List (Note (62, 100, 1000), Note (66, 100, 1000),
//        Note (67, 100, 1000), Note (71, 100, 1000)))
//      , Chord (2000 , List (Note (61, 100, 1000), Note (64, 100, 1000),
//        Note (67, 100, 1000), Note (71, 100, 1000)))
//      , Chord (3000 , List (Note (62, 100, 1000), Note (67, 100, 1000),
//        Note (67, 100, 1000), Note (71, 100, 1000)))
//      , Chord (4000 , List (Note (64, 100, 1000), Note (65, 100, 1000),
//        Note (71, 100, 1000), Note (70, 100, 1000)))
//    ));

  //To test your cantate send this msg
  PlayerActor ! PlayNormal(cantate)

  //End Question 1

  ///////////////////////////////

  class PlayerActor extends Actor {

    //    val remote = context.actorSelection("akka.tcp://Player@127.0.0.1:6000/user/PlayerActor")
    /// To send to my laptop just change the ip adresse to ...

    //    val system = ActorSystem("VoicerSystem")
    val ListenerActor = system.actorOf(Props[ListenerActor], "Listener")
    val MasterActor = system.actorOf(Props(new MasterActor(ListenerActor)), "Master")

    def receive = {
      //      case PlayVoice(num, chords) => {
      //        //Question 2
      //      }
      case PlayNormal(chordseq) => {
        MasterActor ! chordseq
      }
    }
  }


  class MasterActor(listener: ActorRef) extends Actor {
    var nbNotes = 0
    var nbMsg = 0

    for (index <- 0 to cantate.chords.size-1) {
      nbNotes += cantate.chords(index).notes.size
    }

    var workers: List[ActorRef] = List(
      context.actorOf(Props[WorkerActor], "Worker1"),
      context.actorOf(Props[WorkerActor], "Worker2"),
      context.actorOf(Props[WorkerActor], "Worker3"));

    var result: List[Voix] = List(
      new Voix(0, Nil),
      new Voix(1, Nil),
      new Voix(2, Nil),
      new Voix(3, Nil));

    def receive = {

      case chordseq: Chordseq =>
        for (index <- 0 to chordseq.chords.size - 1) {
          workers(index % 3) ! chordseq.chords(index)
        }

      case (id: Int, date: Int, note: Note) =>
        var tmp: Voix = Voix(id, result(id).chords ::: List(Chord(date, List(note))))
        result = result.updated(id, tmp)
        nbMsg += 1;
        if(nbMsg == nbNotes){
          listener ! result
          context.stop(self)
        }
    }
  }


  class ListenerActor extends Actor {
    val remote = context.actorSelection("akka.tcp://Player@127.0.0.1:6000/user/PlayerActor")

    def receive = {
      case list: List[Voix] => remote ! list;
    }
  }

  class WorkerActor extends Actor {
    def receive = {
      case Chord(date, notes) => for (index <- 0 to notes.size - 1) {
        sender ! (index, date, notes(index))
      }
    }
  }

}
////////////////////QUESTION 2