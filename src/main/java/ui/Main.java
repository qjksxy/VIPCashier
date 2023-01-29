package ui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import dao.CustomDao;
import pojo.Custom;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class Main {
    static {
        initializeTheme();
    }

    public static final Font DEFAULT_FONT = new Font("微软雅黑", Font.PLAIN, 20);
    public static final String HUIYUAN_JIAOFEI = "会员缴费";
    public static final String HUIYUAN_XIAOFEI = "会员消费";
    public static final String PUTONG_XIAOFEI = "普通消费";
    public static final String HUIYUAN_XINXI = "会员信息";
    public static final String CHAXUN_JILU = "查询记录";
    public static final String TONGJI_SHUJU = "统计数据";
    private static final JLabel statusLeftLabel = new JLabel(HUIYUAN_JIAOFEI);
    private static final JLabel statusCenterLabel = new JLabel();
    private static final JLabel statusRightLabel = new JLabel();
    private static final JButton hyjfBtn = new JButton(HUIYUAN_JIAOFEI);
    private static final JButton hyxfBtn = new JButton(HUIYUAN_XIAOFEI);
    private static final JButton ptxfBtn = new JButton(PUTONG_XIAOFEI);
    private static final JButton hyxxBtn = new JButton(HUIYUAN_XINXI);
    private static final JButton cxjlBtn = new JButton(CHAXUN_JILU);
    private static final JButton tjsjBtn = new JButton(TONGJI_SHUJU);
    // 设置中心面板
    private static final CardLayout cardLayout = new CardLayout();
    private static final JPanel centerPanel = new JPanel(cardLayout);
    private static final JPanel hyjfPanel = new JPanel();
    private static final JPanel hyxfPanel = new JPanel();
    private static final JPanel ptxfPanel = new JPanel();
    private static final JPanel hyxxPanel = new JPanel();
    private static final JPanel cxjlPanel = new JPanel();
    private static final JPanel tjsjPanel = new JPanel();

    private Main() {
        JFrame mainFrame = new JFrame("红叶理发工作室");
        mainFrame.setSize(800, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());
        statusPanel.setBorder(new LineBorder(new Color(214, 214, 214)));

        statusLeftLabel.setFont(DEFAULT_FONT);
        statusCenterLabel.setFont(DEFAULT_FONT);
        statusRightLabel.setFont(DEFAULT_FONT);
        statusPanel.add(statusLeftLabel, BorderLayout.WEST);
        statusPanel.add(statusCenterLabel, BorderLayout.CENTER);
        statusPanel.add(statusRightLabel, BorderLayout.EAST);
        // statusCenterLabel.setText(statusCenterLabel.getFont().toString());

        // 设置左侧操作区
        JPanel opPanel = new JPanel();
        opPanel.setBorder(new LineBorder(new Color(214, 214, 214)));
        initOpPanel(opPanel);
        initBtnListener();
        initCardPanel();
        initCenterPanels();


        mainPanel.add(opPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.add(statusPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    private static void initOpPanel(JPanel panel) {
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        panel.add(hyjfBtn);
        panel.add(hyxfBtn);
        panel.add(ptxfBtn);
        panel.add(hyxxBtn);
        panel.add(cxjlBtn);
        panel.add(tjsjBtn);

        SpringLayout.Constraints hyjfCon = layout.getConstraints(hyjfBtn);
        SpringLayout.Constraints hyxfCon = layout.getConstraints(hyxfBtn);
        SpringLayout.Constraints ptxfCon = layout.getConstraints(ptxfBtn);
        SpringLayout.Constraints hyxxCon = layout.getConstraints(hyxxBtn);
        SpringLayout.Constraints cxjlCon = layout.getConstraints(cxjlBtn);
        SpringLayout.Constraints tjsjCon = layout.getConstraints(tjsjBtn);

        hyjfCon.setX(Spring.constant(5));
        hyjfCon.setY(Spring.constant(5));
        hyxfCon.setX(Spring.constant(5));
        hyxfCon.setY(hyjfCon.getConstraint(SpringLayout.SOUTH));
        ptxfCon.setX(Spring.constant(5));
        ptxfCon.setY(hyxfCon.getConstraint(SpringLayout.SOUTH));
        hyxxCon.setX(Spring.constant(5));
        hyxxCon.setY(ptxfCon.getConstraint(SpringLayout.SOUTH));
        cxjlCon.setX(Spring.constant(5));
        cxjlCon.setY(hyxxCon.getConstraint(SpringLayout.SOUTH));
        tjsjCon.setX(Spring.constant(5));
        tjsjCon.setY(cxjlCon.getConstraint(SpringLayout.SOUTH));

        SpringLayout.Constraints panelCon = layout.getConstraints(panel);
        panelCon.setConstraint(
                SpringLayout.EAST,
                Spring.sum(
                        tjsjCon.getConstraint(SpringLayout.EAST),
                        Spring.constant(5)));

    }

    private static void initCardPanel() {
        centerPanel.add(HUIYUAN_JIAOFEI, hyjfPanel);
        centerPanel.add(HUIYUAN_XIAOFEI, hyxfPanel);
        centerPanel.add(PUTONG_XIAOFEI, ptxfPanel);
        centerPanel.add(HUIYUAN_XINXI, hyxxPanel);
        centerPanel.add(CHAXUN_JILU, cxjlPanel);
        centerPanel.add(TONGJI_SHUJU, tjsjPanel);
    }

    private static void initBtnListener() {
        hyjfBtn.addActionListener(e -> statusLeftLabel.setText(HUIYUAN_JIAOFEI));
        hyxfBtn.addActionListener(e -> statusLeftLabel.setText(HUIYUAN_XIAOFEI));
        ptxfBtn.addActionListener(e -> statusLeftLabel.setText(PUTONG_XIAOFEI));
        hyxxBtn.addActionListener(e -> statusLeftLabel.setText(HUIYUAN_XINXI));
        cxjlBtn.addActionListener(e -> statusLeftLabel.setText(CHAXUN_JILU));
        tjsjBtn.addActionListener(e -> statusLeftLabel.setText(TONGJI_SHUJU));

        hyjfBtn.addActionListener(e -> cardLayout.show(centerPanel, HUIYUAN_JIAOFEI));
        hyxfBtn.addActionListener(e -> cardLayout.show(centerPanel, HUIYUAN_XIAOFEI));
        ptxfBtn.addActionListener(e -> cardLayout.show(centerPanel, PUTONG_XIAOFEI));
        hyxxBtn.addActionListener(e -> cardLayout.show(centerPanel, HUIYUAN_XINXI));
        cxjlBtn.addActionListener(e -> cardLayout.show(centerPanel, CHAXUN_JILU));
        tjsjBtn.addActionListener(e -> cardLayout.show(centerPanel, TONGJI_SHUJU));
    }

    private static void initCenterPanels() {
        JPanel panel = hyjfPanel;
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel nameLabel = new JLabel("姓名");panel.add(nameLabel);
        nameLabel.setFont(DEFAULT_FONT);
        JLabel phoneLabel = new JLabel("电话");panel.add(phoneLabel);
        phoneLabel.setFont(DEFAULT_FONT);
        JLabel amountLabel = new JLabel("充值金额");panel.add(amountLabel);
        amountLabel.setFont(DEFAULT_FONT);
        JLabel levelLabel = new JLabel("充值级别");panel.add(levelLabel);
        levelLabel.setFont(DEFAULT_FONT);
        JLabel remarkLabel = new JLabel("备注");panel.add(remarkLabel);
        remarkLabel.setFont(DEFAULT_FONT);
        JTextField nameField = new JTextField();panel.add(nameField);
        JTextField phoneField = new JTextField();panel.add(phoneField);
        JTextField amountField = new JTextField();panel.add(amountField);
        JTextField levelField = new JTextField();panel.add(levelField);
        JTextField remarkField = new JTextField();panel.add(remarkField);
        JButton okBtn = new JButton("确认");
        okBtn.setFont(DEFAULT_FONT);panel.add(okBtn);


        SpringLayout.Constraints nameLabelCon = layout.getConstraints(nameLabel);
        SpringLayout.Constraints phoneLabelCon = layout.getConstraints(phoneLabel);
        SpringLayout.Constraints amountLabelCon = layout.getConstraints(amountLabel);
        SpringLayout.Constraints levelLabelCon = layout.getConstraints(levelLabel);
        SpringLayout.Constraints remarkLabelCon = layout.getConstraints(remarkLabel);
        SpringLayout.Constraints nameFieldCon = layout.getConstraints(nameField);
        SpringLayout.Constraints phoneFieldCon = layout.getConstraints(phoneField);
        SpringLayout.Constraints amountFieldCon = layout.getConstraints(amountField);
        SpringLayout.Constraints levelFieldCon = layout.getConstraints(levelField);
        SpringLayout.Constraints remarkFieldCon = layout.getConstraints(remarkField);
        SpringLayout.Constraints okBtnCon = layout.getConstraints(okBtn);

        nameLabelCon.setX(Spring.constant(20));
        phoneLabelCon.setX(nameLabelCon.getConstraint(SpringLayout.WEST));
        amountLabelCon.setX(nameLabelCon.getConstraint(SpringLayout.WEST));
        levelLabelCon.setX(nameLabelCon.getConstraint(SpringLayout.WEST));
        remarkLabelCon.setX(nameLabelCon.getConstraint(SpringLayout.WEST));

        amountFieldCon.setX(Spring.sum(amountLabelCon.getConstraint(SpringLayout.EAST),
                Spring.constant(20)));
        nameFieldCon.setX(amountFieldCon.getConstraint(SpringLayout.WEST));
        phoneFieldCon.setX(amountFieldCon.getConstraint(SpringLayout.WEST));
        levelFieldCon.setX(amountFieldCon.getConstraint(SpringLayout.WEST));
        remarkFieldCon.setX(amountFieldCon.getConstraint(SpringLayout.WEST));

        nameLabelCon.setY(Spring.constant(20));
        phoneLabelCon.setY(
                Spring.sum(
                    nameLabelCon.getConstraint(SpringLayout.SOUTH),
                    Spring.constant(20)));
        amountLabelCon.setY(
                Spring.sum(
                        phoneLabelCon.getConstraint(SpringLayout.SOUTH),
                        Spring.constant(20)));
        levelLabelCon.setY(
                Spring.sum(
                        amountLabelCon.getConstraint(SpringLayout.SOUTH),
                        Spring.constant(20)));
        remarkLabelCon.setY(
                Spring.sum(
                        levelLabelCon.getConstraint(SpringLayout.SOUTH),
                        Spring.constant(20)));
        nameFieldCon.setY(nameLabelCon.getConstraint(SpringLayout.NORTH));
        phoneFieldCon.setY(phoneLabelCon.getConstraint(SpringLayout.NORTH));
        amountFieldCon.setY(amountLabelCon.getConstraint(SpringLayout.NORTH));
        levelFieldCon.setY(levelLabelCon.getConstraint(SpringLayout.NORTH));
        remarkFieldCon.setY(remarkLabelCon.getConstraint(SpringLayout.NORTH));


        okBtnCon.setX(nameLabelCon.getX());
        okBtnCon.setY(Spring.sum(
                remarkLabelCon.getConstraint(SpringLayout.SOUTH),
                Spring.constant(20)));
        okBtn.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String level = levelField.getText();
            String remark = remarkField.getText();
            int amount = Integer.parseInt(amountField.getText());
            int balance = amount;

            Custom custom = new Custom(phone, name, amount, balance, level, remark);
            if (!CustomDao.exists()) {
                CustomDao.createTable();
            }

            List<Custom> customs = CustomDao.selectCustomByPhone(custom.getPhone());
            if (customs.isEmpty()) {
                CustomDao.insertCustom(custom);
                Dialog.showDialog("提示", "成功添加用户");
                nameField.setText("");
                phoneField.setText("");
                levelField.setText("");
                remarkField.setText("");
                amountField.setText("");
            } else {
                Dialog.showDialog("错误", "该用户[" + customs.get(0).getPhone() + ": " + customs.get(0).getName() + "]已经存在，请检查电话号");
            }
        });
    }

    private static void springTest() {
        // 创建窗口
        JFrame jf = new JFrame("测试窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);

        // 创建内容面板，使用 弹性布局
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);
        jf.setContentPane(panel);

        // 创建组件
        JLabel label = new JLabel("Test JLabel: ");
        JButton btn = new JButton("Btn");
        JTextField textField = new JTextField("Text Field");

        // 添加组件到内容面板
        panel.add(label);
        panel.add(btn);
        panel.add(textField);

        /*
         * 组件的约束设置（弹性布局设置的关键）
         */

        // 标签组件约束: 设置标签的左上角坐标为 (5, 5)
        SpringLayout.Constraints labelCons = layout.getConstraints(label);  // 从布局中获取指定组件的约束对象（如果没有，会自动创建）
        labelCons.setX(Spring.constant(5));
        labelCons.setY(Spring.constant(5));

        // 按钮组件约束: 设置左上角 水平坐标为5, 垂直坐标为 标签的南边坐标；设置东边坐标为 标签的东边坐标
        SpringLayout.Constraints btnCons = layout.getConstraints(btn);
        btnCons.setX(Spring.constant(5));
        btnCons.setY(labelCons.getConstraint(SpringLayout.SOUTH));
        btnCons.setConstraint(SpringLayout.EAST, labelCons.getConstraint(SpringLayout.EAST));

        // 文本框约束: 设置左上角 水平坐标为 标签的东边坐标 + 5, 垂直坐标为 5
        SpringLayout.Constraints textFieldCons = layout.getConstraints(textField);
        textFieldCons.setX(
                Spring.sum(
                        labelCons.getConstraint(SpringLayout.EAST),
                        Spring.constant(5)
                )
        );
        textFieldCons.setY(Spring.constant(5));

        /*
         * 内容面板（容器）的约束设置，即确定 组件 和 容器的右边和底边 之间的间隙大小
         */
        SpringLayout.Constraints panelCons = layout.getConstraints(panel);  // 获取容器的约束对象

        // 设置容器的 东边坐标 为 文本框的东边坐标 + 5
        panelCons.setConstraint(
                SpringLayout.EAST,
                Spring.sum(
                        textFieldCons.getConstraint(SpringLayout.EAST),
                        Spring.constant(5)
                )
        );

        // 计算出 按钮 和 文本框 的 南边坐标 的 值较大者
        Spring maxHeightSpring = Spring.max(
                btnCons.getConstraint(SpringLayout.SOUTH),
                textFieldCons.getConstraint(SpringLayout.SOUTH)
        );

        // 设置容器的 南边坐标 为 maxHeightSpring + 5
        panelCons.setConstraint(
                SpringLayout.SOUTH,
                Spring.sum(
                        maxHeightSpring,
                        Spring.constant(5)
                )
        );

        // 显示窗口
        jf.setVisible(true);
    }

    private static void initializeTheme() {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch(Exception ignore) {
            System.err.println("Failed to initialize LaF");
            if (statusLeftLabel != null) {
                statusLeftLabel.setText("Failed to initialize LaF");
            }
        }
    }

    public static void main(String[] args) {
        // 加载主题
        // initializeTheme();

        new Main();
    }
}

