import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JingeriaStart extends JFrame implements ActionListener {
	
	 java.util.Timer timer;  
	 
	 int countdown = 30;
	
	SpongeBob sb = new SpongeBob();
	Squidward sw = new Squidward();
	Krabs kk = new Krabs();

	Producer pdc = new Producer();
	Consumer csm = new Consumer();
	
	Point pt = new Point();
	
	JFrame roadingFrame, gameFrame,gamePlayFrame, rulesFrame,endingFrame;
	JPanel roadingBackground, gameBackground, menu, rulesPanel, gamePlayBackground,spongeBob,  squidward, krabs;
	JPanel table, pattyImg, vegetablesImg, bunImg, patrickImg,checkBoard,burgerImg, board, checkPanel,blackBoard, failImg,successImg;
	JButton Start, produce,consume;
	JButton gameRules, rulesOut, pattyButton, vegetablesButton, bunButton;  
	JLabel Loading, patty, vegetables, bun, askedBurgerNum, pattyNum, vegetablesNum,bunNum, burger, burgerNum,burgerConsume, burgerConsumeNum;
	JLabel time,check;
	 boolean isGameStart = false; // false 정지 true 스타트
	
	int sbMaterial=0, swMaterial=0, kkMaterial=0,burgerCount=0,burgerConsumeCount=0;

	public JingeriaStart() {
		
		
		roadingFrame = new JFrame(); // 
		gameFrame = new JFrame();
		gamePlayFrame = new JFrame();
		rulesFrame = new JFrame();
		endingFrame = new JFrame();
		
		roadingBackground = new JPanel(){ ImageIcon i = new ImageIcon("img/Sky.jpg");	// 로딩 배경
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 1000, 1000, null);
		}
	    };
	    roadingBackground.setLayout(null);
	   
	    gameBackground = new JPanel(){ImageIcon i = new ImageIcon("img/Jingeria.jpg");	// 로딩 이후 게임 시작 배경
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 800, 800, null);
		}
	    };
	    gameBackground.setLayout(null);
	    
		menu = new JPanel(){ ImageIcon i = new ImageIcon("img/White.png");	 // 메뉴 
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 500, null);
		} 
	    };
	   
	    rulesPanel = new JPanel(){ImageIcon i = new ImageIcon("img/rulesImg.jpg");	 // 게임 방법 설명 배경
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 800, 800, null);
			}
	    };	
		rulesPanel.setLayout(null);
		
		gamePlayBackground = new JPanel(){ImageIcon i = new ImageIcon("img/Kitchen.jpg");	 // 게임 플레이 배경
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 900, 500, null);
			}
	    };
	    gamePlayBackground.setLayout(null);

	    failImg = new JPanel(){ImageIcon i = new ImageIcon("img/FailImg.png");	 // 실패
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 800, 800, null);
			}
	    };
	    failImg.setLayout(null);
	    
	    successImg = new JPanel(){ImageIcon i = new ImageIcon("img/SuccessImg.png");	 // 성공 
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 800, 800, null);
			}
	    };
	    failImg.setLayout(null);
		
	    spongeBob = new JPanel(){ ImageIcon i = new ImageIcon("img/SpongeBobImg.png");	 // 스폰지밥
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 200, this);
		} 
	    }; 
	    spongeBob.setBounds(70, 160, 200, 500); 
	
	    squidward =  new JPanel(){ ImageIcon i = new ImageIcon("img/SquidwardImg.png");	 // 징징이
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 300, null);
		} 
	    };  
	    squidward.setBounds(280, 90, 200, 500); 
		
	    krabs = new JPanel(){ ImageIcon i = new ImageIcon("img/krabsImg.png");	 // 집게사장
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 300, 300, null);
		}
	    }; 
	    krabs.setBounds(450, 110, 400, 800); 
	    
	    board = new JPanel(){ ImageIcon i = new ImageIcon("img/DarkTree.jpg");	 // 좌측 판
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 300, 1000, null);
		}
	    }; 
	    board.setBounds(750, 0, 400, 3000);
	    board.setLayout(null);
	    
	    table = new JPanel(){ ImageIcon i = new ImageIcon("img/BrightTree.jpg");	 // 재료 준비 판
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 750, 1000, null);
		}
	    };
	    table.setBounds(0, 335, 1200, 500); 
		
	    pattyImg = new JPanel(){ ImageIcon i = new ImageIcon("img/PattyImg.png");	  // 패티 
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 150, 150, null);
		}
	    };
	    pattyImg.setBounds(80, 300, 200, 200); 

	    
	    vegetablesImg = new JPanel(){ ImageIcon i = new ImageIcon("img/VegetablesImg.png");	// 채소
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 250, 250, null);
		}
	    }; 
	    vegetablesImg.setBounds(250, 250, 300, 300); 
	    
	    bunImg = new JPanel(){ ImageIcon i = new ImageIcon("img/BunImg.png");	// 빵
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 200, null);
		}
	    }; 
	
	    bunImg.setBounds(500, 300, 200, 200); 

	    patrickImg = new JPanel(){ ImageIcon i = new ImageIcon("img/PatrickImg.png");	// 뚱이
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 300, 400, null);
		}
	    }; 
	    patrickImg.setBounds(200, 490, 1500, 1000);
	    
	    checkBoard = new JPanel(){ ImageIcon i = new ImageIcon("img/CheckBoardImg.jpg");	// 개수 확인
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 250, null);
		}
	    }; 
	    checkBoard.setBounds(25, 140, 200, 300); 
		checkBoard.setLayout(null);
	    
		burgerImg = new JPanel(){ ImageIcon i = new ImageIcon("img/BurgerImg.png");	 // 게살버거
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 200, 400, null);
		}
	    }; 	  
	    burgerImg.setBounds(25, 300, 250, 500); 

	    
	    blackBoard = new JPanel(){ImageIcon i = new ImageIcon("img/BlackBoard.png");	 // 검정 알림 판
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 500, 100, null);
			}
	    };
	    blackBoard.setBounds(250, 50, 300, 50); 

		
		Start = new JButton(){ 
			/* ImageIcon i = new ImageIcon("e:\\img\\StartButton.png");
			 public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 500, 500, null);
			} */
		};

		Start.setText("Start");
		Start.setBounds(0, 100, 1000, 50);
		
		Start.addActionListener(this);
		
		gameRules  = new JButton(){ /*
			ImageIcon i = new ImageIcon("img/흰색.png");
			 public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 500, 500, null);
			} */
		};
		
		gameRules.setText("gameRules");
		gameRules.setBounds(0, 200, 200, 50);
		gameRules.addActionListener(this);
		
		rulesOut = new JButton(){ 
			/* ImageIcon i = new ImageIcon("e:\\img\\StartButton.png");
			 public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 500, 500, null);
			} */
		};
		rulesOut.setText("out");
		rulesOut.setBounds(20, 670, 100, 50);
		rulesOut.addActionListener(this);
		
	    produce = new JButton(){ 
			/*
			 ImageIcon i = new ImageIcon("e:\\img\\StartButton.png");
			 public void paintComponent(Graphics g) {
			 g.drawImage(i.getImage(), 0, 0, 1000, 1000, null);
			}
			*/
		};
		produce.setBounds(820, 580, 100, 50);
		produce.addActionListener(this);
		
	    consume = new JButton(){ 
				/*
				 ImageIcon i = new ImageIcon("e:\\img\\StartButton.png");
				 public void paintComponent(Graphics g) {
				 g.drawImage(i.getImage(), 0, 0, 1000, 1000, null);
				}
				*/
			};
			consume.setBounds(820, 650, 100, 50);
			consume.addActionListener(this);

	    pattyButton = new JButton(){                                                                    
			/* ImageIcon i = new ImageIcon("e:\\img\\StartButton.png");
			 public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 500, 500, null);
			} */
		};
		pattyButton.setBounds(100, 450, 100, 50);
		pattyButton.addActionListener(this);

		vegetablesButton = new JButton(){ 
			/* ImageIcon i = new ImageIcon("e:\\img\\StartButton.png");
			 public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 500, 500, null);
			} */
		};
		vegetablesButton.setBounds(320, 450, 100, 50);
		vegetablesButton.addActionListener(this);

		
		bunButton = new JButton(){ 
			/* ImageIcon i = new ImageIcon("e:\\img\\StartButton.png");
			 public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 500, 500, null);
			} */
		};
		bunButton.setBounds(550, 450, 100, 50);
		bunButton.addActionListener(this);

	    Loading = new JLabel();
		Loading.setOpaque(false);
		Loading.setFont(new Font("Dialog.plain", 0, 50));
		Loading.setHorizontalAlignment(SwingConstants.CENTER);
		Loading.setForeground(new Color(100,100,100));
		Loading.setBounds(800,500,100,100);   
		
	    time = new JLabel("30");
	    time .setOpaque(false);
	    time .setFont(new Font("Dialog.plain", 0, 50));
	    time .setHorizontalAlignment(SwingConstants.CENTER);
	    time .setForeground(new Color(0,0,0));
	    time .setBounds(60,20,100,100); 
	
		askedBurgerNum = new JLabel();
		askedBurgerNum.setOpaque(false);
		askedBurgerNum.setFont(new Font("Dialog.plain", 0, 30));
		askedBurgerNum.setHorizontalAlignment(SwingConstants.CENTER);
		askedBurgerNum.setForeground(new Color(0,0,0));
		askedBurgerNum.setBounds(450, 650, 300, 100);	
		
	    patty = new JLabel();
		patty.setOpaque(false);
		patty.setFont(new Font("Dialog.plain", 0, 15));
		patty.setHorizontalAlignment(SwingConstants.CENTER);
		patty.setForeground(new Color(0,0,0));
		patty.setBounds(10,0,100,100);  
		
	    pattyNum = new JLabel();
		pattyNum .setOpaque(false);
		pattyNum .setFont(new Font("Dialog.plain", 0, 20));
		pattyNum .setHorizontalAlignment(SwingConstants.CENTER);
		pattyNum .setForeground(new Color(0,0,0));
		pattyNum .setBounds(60,0,100,100);  
		
		vegetables = new JLabel();
		vegetables.setOpaque(false);
		vegetables.setFont(new Font("Dialog.plain", 0, 15));
		vegetables.setHorizontalAlignment(SwingConstants.CENTER);
		vegetables.setForeground(new Color(0,0,0));
		vegetables.setBounds(10,20,100,100);  
		
		vegetablesNum = new JLabel();
		vegetablesNum.setOpaque(false);
		vegetablesNum.setFont(new Font("Dialog.plain", 0, 20));
		vegetablesNum.setHorizontalAlignment(SwingConstants.CENTER);
		vegetablesNum.setForeground(new Color(0,0,0));
		vegetablesNum.setBounds(60,20,100,100);  
	
	    bun = new JLabel();
		bun.setOpaque(false);
		bun.setFont(new Font("Dialog.plain", 0, 15));
		bun.setHorizontalAlignment(SwingConstants.CENTER);
		bun.setForeground(new Color(0,0,0));
		bun.setBounds(10,40,100,100);
	
	    bunNum = new JLabel();
		bunNum.setOpaque(false);
		bunNum.setFont(new Font("Dialog.plain", 0, 20));
		bunNum.setHorizontalAlignment(SwingConstants.CENTER);
		bunNum.setForeground(new Color(0,0,0));
		bunNum.setBounds(60,40,100,100);  
		 
	    burger= new JLabel();
	    burger.setOpaque(false);
	    burger.setFont(new Font("Dialog.plain", 0, 15));
	    burger.setHorizontalAlignment(SwingConstants.CENTER);
	    burger.setForeground(new Color(0,0,0));
	    burger.setBounds(20,90,100,100);
					
	    burgerNum = new JLabel();
	    burgerNum.setOpaque(false);
	    burgerNum.setFont(new Font("Dialog.plain", 0, 20));
	    burgerNum.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerNum.setForeground(new Color(0,0,0));
	    burgerNum.setBounds(90,90,100,100);  
	    
	    burgerConsume= new JLabel();
	    burgerConsume.setOpaque(false);
	    burgerConsume.setFont(new Font("Dialog.plain", 0, 15));
	    burgerConsume.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerConsume.setForeground(new Color(0,0,0));
	    burgerConsume.setBounds(20,130,100,100);
					
	    burgerConsumeNum = new JLabel();
	    burgerConsumeNum.setOpaque(false);
	    burgerConsumeNum.setFont(new Font("Dialog.plain", 0, 20));
	    burgerConsumeNum.setHorizontalAlignment(SwingConstants.CENTER);
	    burgerConsumeNum.setForeground(new Color(0,0,0));
	    burgerConsumeNum.setBounds(90,130,100,100);  

	    check = new JLabel();
	    check.setOpaque(false);
	    check.setFont(new Font("Dialog.plain", 0, 15));
	    check.setHorizontalAlignment(SwingConstants.CENTER);
	    check.setForeground(new Color(255,255,255));
	    check.setBounds(0,0,100,100);  
	    
	    Loading = new JLabel();
		Loading.setOpaque(false);
		Loading.setFont(new Font("Dialog.plain", 0, 30));
		Loading.setHorizontalAlignment(SwingConstants.CENTER);
		Loading.setForeground(new Color(0,0,0));
		Loading.setBounds(300,500,200,200);   
		roadingBackground.add(Loading);

		roadingFrame.add(roadingBackground);
	 	roadingFrame.setSize(800,800);  
	 	roadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		roadingFrame.setTitle("집게리아로 가자");
		roadingFrame.setVisible(true);
		roadingFrame.setResizable(false);
	 	
		for(int i =0;i<2;i++){
			Loading.setText("Loading      ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Loading.setText("Loading .    ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Loading.setText("Loading . .  ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Loading.setText("Loading . . .");
			try { 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		 
		roadingFrame.setVisible(false);  // 로딩창 닫기


		menu.add(Start);	
		menu.add(gameRules);
		gameBackground.add(menu);
	    menu.setBounds(50, 500, 100, 100); 
	    gameFrame.add(gameBackground);	   
	    gameFrame.setSize(800,800); 
	    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setTitle("집게리아에서 집게버거 만들기");
		gameFrame.setVisible(true);
		gameFrame.setResizable(false);
		
	}
	
	
	public void play() {   // 게임 플레이
		
		gameFrame.setVisible(false);
		
		patty.setText("패티");
		checkBoard.add(patty);
		
		pattyNum.setText("0");
		checkBoard.add(pattyNum);
		
		vegetables.setText("채소");
		checkBoard.add(vegetables);
		
		vegetablesNum.setText("0");
		checkBoard.add(vegetablesNum);
		
		bun.setText("빵");
		checkBoard.add(bun);
		
		bunNum.setText("0");
		checkBoard.add(bunNum);
		
		burger.setText("게살버거 생산");
		checkBoard.add(burger);
		
		burgerNum.setText("0");
		checkBoard.add(burgerNum);
		
		
		burgerConsume.setText("게살버거 소비");
		checkBoard.add(burgerConsume);
		
		burgerConsumeNum.setText("0");
		checkBoard.add(burgerConsumeNum);
		
	
		produce.setText("produce");
		gamePlayBackground.add(produce);
		
		
		consume.setText("consume");
		gamePlayBackground.add(consume);
		
		board.add(time);

		askedBurgerNum.setText("목표: 게살버거 30개");
		gamePlayBackground.add(askedBurgerNum);
		
		gamePlayBackground.add(patrickImg);  // 뚱이
		
		gamePlayBackground.add(pattyImg);  // 패티 
		gamePlayBackground.add(vegetablesImg);  // 야채 
		gamePlayBackground.add(bunImg);  // 빵 
	    
		pattyButton.setText("pattyButton");
		gamePlayBackground.add(pattyButton);

		vegetablesButton.setText("vegetablesButton");
		gamePlayBackground.add(vegetablesButton);

		bunButton.setText("bunButton");
		gamePlayBackground.add(bunButton);
		
		gamePlayBackground.add(board);  // 좌측판

		gamePlayBackground.add(table);  // 재료 준비 판

		gamePlayBackground.add(spongeBob); // 스폰지밥
		gamePlayBackground.add(squidward); // 징징이
		gamePlayBackground.add(krabs); // 집게사장
		
		gamePlayBackground.add(blackBoard); // 검정 알람 판
		
		board.add(checkBoard); // 갯수 판
		board.add(burgerImg); // 게살 버거
	    
	    gamePlayBackground.add(board); // 체크판
	    
	    

		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setSize(1000,800); 
	 	gamePlayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePlayFrame.setTitle("집게리아에서 집게버거 만들기");
		gamePlayFrame.setVisible(true);
		gamePlayFrame.setResizable(false);
	}

	
	public void rules() { // 게임 설명

	rulesPanel.add(rulesOut);

	rulesFrame.add(rulesPanel);
	rulesFrame.setBounds(0, 0, 800, 800);  
	rulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	rulesFrame.setTitle("게임설명");
	rulesFrame.setVisible(true);
	rulesFrame.setResizable(false);


	}
	
	public void rulesOut() { // 게임 설명 창 닫기
		
		rulesFrame.setVisible(false);

	}
	
	public void pattyPoint() { // 패티 개수

	 sb.produce();
		sbMaterial++;

	}
	
	public void pattyPrint() { // 패티 출력

		pattyNum.setText(""+sbMaterial);

		checkBoard.add(pattyNum);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);
	}
	
	public void vegetablesPoint() { // 채소 개수
		 sw.produce();
			swMaterial++;
	}

	public void vegetablesPrint() { //채소 출력
				
	vegetablesNum.setText(""+swMaterial); 			
	
	checkBoard.add(vegetablesNum);
	board.add(checkBoard);
	gamePlayBackground.add(board);
	gamePlayFrame.add(gamePlayBackground);
	gamePlayFrame.setVisible(true);

	}
	
	public void bunPoint() { // 빵 개수
		 kk.produce();
			kkMaterial++;
		
	}
	
	public void bunPrint() { // 빵 출력	
		
	bunNum.setText(""+kkMaterial); 

	checkBoard.add(bunNum);
	board.add(checkBoard);
	gamePlayBackground.add(board);
	gamePlayFrame.add(gamePlayBackground);
	gamePlayFrame.setVisible(true);
	
	}
	
	public void  produce() {  // 게살 버거 생산
		
		if(sbMaterial>=1&&swMaterial>=1&&kkMaterial>=1) {
					
			sbMaterial-=1;
			swMaterial-=1;
			kkMaterial-=1;
			
			pdc.produce();
			burgerCount+=1;
			
			pattyNum.setText(""+sbMaterial);
		
			vegetablesNum.setText(""+swMaterial); 
			
			bunNum.setText(""+kkMaterial); 
	
			burgerNum.setText(""+burgerCount);
	
			check.setText("생산자들이 게살버거을 생산하였습니다.");
			
		} else check.setText("'재료'가 부족합니다.");

		checkBoard.add(pattyNum);
		checkBoard.add(vegetablesNum);
		checkBoard.add(bunNum);
		checkBoard.add(burgerNum);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		
		blackBoard.add(check);
		gamePlayBackground.add(blackBoard);
		
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);
	
	}

	
	public void consume() { // 게살 버거 소비
	
		if (burgerCount>0) {
			csm.consume();

			burgerCount-=1;
			burgerConsumeCount+=1;

			burgerNum.setText(""+burgerCount);
			burgerConsumeNum.setText(""+burgerConsumeCount); 
			
			check.setText("'뚱이'가 게살버거을 먹었다.");
			
		} else check.setText("게살버거가 없습니다.");
		
		checkBoard.add(burgerNum);
		checkBoard.add(burgerConsumeNum);
		board.add(checkBoard);
		gamePlayBackground.add(board);
		
		blackBoard.add(check);
		gamePlayBackground.add(blackBoard);
				
		gamePlayFrame.add(gamePlayBackground);
		gamePlayFrame.setVisible(true);
		
		
	}
	
	public void gameOver() { // 실패

		gamePlayFrame.setVisible(false);
		

	 	endingFrame.add(failImg);
		endingFrame.setSize(800,800); 
	 	endingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	endingFrame.setTitle("GAMEOVER");
		endingFrame.setVisible(true);
	
	}
	
	public void clear() { // 성공
		gamePlayFrame.setVisible(false);
		

	 	endingFrame.add(successImg);
		endingFrame.setSize(800,800); 
		endingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endingFrame.setTitle("CLEAR");
		endingFrame.setVisible(true);
	}
	
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==Start&& !isGameStart) {
				// 스타트 버튼을 눌렸을때 
				
				play();		
				//게임 시간 초기화
			    countdown = 30;
			    
			    //게임 시작을 알림
			    isGameStart = true;
			
			    //1초마다 한번씩 실행 되는 타이머 만들기
			    timer = new Timer();
			    timer.schedule(new TimerTask() {
			     @Override
				     public void run() {
					      if (isGameStart) {    
						       //1초씩 카운트
						       countdown--;
						       
						       //시간이 다되면(게임오버)
						       if(countdown < 0 && burgerConsumeCount<30)  {
						        timer.cancel();
						        isGameStart = false;
						        gameOver();
						       } else if (countdown <0 && burgerConsumeCount >=30) {
							        timer.cancel();
							        isGameStart = false;
							        clear();
						       }
						       
						       //남은 시간을 출력
						       time.setText("" + countdown);     
					      }
				     }
			    }, 0, 1000);
			    
			} else if (e.getSource()==gameRules)  {
				// 게임 방법을 눌렸을 때
				rules();
				
			} else if (e.getSource()==rulesOut) {
				// 게임 방법에서 창닫기를 눌렸을 때
				rulesOut();
				
			}  else if (e.getSource()==pattyButton) {
				// 패티 버튼을 눌렀을 때
				pattyPoint();
				pattyPrint();	
			
			} else if (e.getSource()==vegetablesButton) {
				// 채소 버튼을 눌렀을 때
				vegetablesPoint();
				vegetablesPrint();
				
			} else if (e.getSource()==bunButton) {
				// 빵 버튼을 눌렀을 때
				bunPoint();
				bunPrint();
				
			}  else if (e.getSource()==produce) {
				// 생산 버튼을 눌렀을 때
				produce();

			}  else if (e.getSource()==consume) {
				// 소비 버튼을 눌렀을 때
				consume();
			}

		}
	}
