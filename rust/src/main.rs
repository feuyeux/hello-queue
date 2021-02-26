use std::sync::mpsc;
use std::sync::mpsc::{Receiver, Sender};
use rand::Rng;
use tokio::time;

const MIN: i32 = 1;
const MAX: i32 = 20;

async fn produce(tx: Sender<Vec<i32>>) {
    let mut list = vec![];
    for _ in 0..10 {
        list.push(random_one());
    }
    tx.send(list).unwrap();
}

// https://docs.rs/tokio/1.2.0/tokio/time/index.html
#[tokio::main]
async fn main() {
    let (tx, rx) = mpsc::channel();
    let interval = time::interval(time::Duration::from_secs(5));
    tokio::pin!(interval);
    for _i in 0..std::i32::MAX {
        interval.as_mut().tick().await;
        produce(tx.clone()).await;
        consume(&rx).await;
    }
}

async fn consume(rx: &Receiver<Vec<i32>>) {
    let mut list: Vec<i32> = rx.recv().unwrap();
    println!("\nreceived:\n{:?}", list);
    list.sort();
    list.dedup();
    println!("handled:\n{:?}", list[0..5].to_vec());
}

fn random_one() -> i32 {
    let mut rng = rand::thread_rng();
    rng.gen_range(MIN..MAX)
}
