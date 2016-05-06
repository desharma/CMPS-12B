//queue.c
//This class contains the structure of the queue and the methods
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "queue.h"

#define STUBPRINTF(...) fprintf(stderr, __VA_ARGS__);

/* Internal implementation definitions */
struct queue_node {
   queue_item_t item;
   struct queue_node *link;
};

typedef struct queue_node queue_node;

struct queue {
   queue_node *front;
   queue_node *rear;
};

/* Functions */

queue *queue_new(void) {
   queue *myQueue = malloc(sizeof(struct queue));
   return myQueue;
}

void queue_free(queue *this) {
   
   free(this);
}

void queue_insert(queue *this, queue_item_t item) {
  queue_node *myNode = malloc(sizeof(struct queue_node));
 myNode->item = item;
 myNode->item = NULL;
  if(queue_isempty(this))
  {
	  this->front = myNode;
	  this->rear = myNode;
  } else 
  {
	  this->rear->link = myNode;
	  this->rear = this->rear->link; 
  }
}

queue_item_t queue_remove(queue *this) {
   assert(!queue_isempty(this));
   queue_item_t temp = this->front->item;
   queue_node  *nNode = this->front->link;
   free(this->front);
   
   if (this->front == this->rear)
	{
	   this->rear = NULL;
	   this->front = NULL;
	}
	this->front = nNode;
	
	return temp;
 
}

bool queue_isempty(queue *this) {
   return this->front == NULL;
}