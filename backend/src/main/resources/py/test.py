if __name__ == '__main__':
 if len(sys.argv) < 2:
        print("缺少参数")
         sys.exit(1)
     tsCode = sys.argv[1]
     result=predict(tsCode)
     print(result)
     connection = pika.BlockingConnection(pika.ConnectionParameters(
           host='localhost',
           port=5672,
           credentials=pika.PlainCredentials('guest', 'guest')
     ))
     channel = connection.channel()
     channel.queue_declare(queue='my_queue')
     print("成功建立了连接")
     result_list = result.values.tolist()
     result_json = json.dumps(result_list)
     channel.basic_publish(exchange='', routing_key='my_queue', body=result_json)
     print("成功发送数据")
     connection.close()

