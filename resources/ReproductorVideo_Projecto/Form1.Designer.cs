namespace Video
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.mediaPLayer = new AxWMPLib.AxWindowsMediaPlayer();
            this.lblTitulo = new System.Windows.Forms.Label();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.lblHora = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.mediaPLayer)).BeginInit();
            this.SuspendLayout();
            // 
            // mediaPLayer
            // 
            this.mediaPLayer.Dock = System.Windows.Forms.DockStyle.Top;
            this.mediaPLayer.Enabled = true;
            this.mediaPLayer.Location = new System.Drawing.Point(0, 0);
            this.mediaPLayer.Margin = new System.Windows.Forms.Padding(2);
            this.mediaPLayer.Name = "mediaPLayer";
            this.mediaPLayer.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("mediaPLayer.OcxState")));
            this.mediaPLayer.Size = new System.Drawing.Size(600, 152);
            this.mediaPLayer.TabIndex = 0;
            // 
            // lblTitulo
            // 
            this.lblTitulo.BackColor = System.Drawing.Color.Transparent;
            this.lblTitulo.Font = new System.Drawing.Font("Futura Md BT", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTitulo.ForeColor = System.Drawing.Color.Black;
            this.lblTitulo.Location = new System.Drawing.Point(34, 318);
            this.lblTitulo.Name = "lblTitulo";
            this.lblTitulo.Size = new System.Drawing.Size(262, 31);
            this.lblTitulo.TabIndex = 1;
            this.lblTitulo.Text = "GERENCIA REGIONAL DE TRANSPORTES Y COMUNICACIONES LES DA LA BIENVENIDA";
            this.lblTitulo.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // timer1
            // 
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // lblHora
            // 
            this.lblHora.BackColor = System.Drawing.Color.LawnGreen;
            this.lblHora.Font = new System.Drawing.Font("Futura Md BT", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblHora.ForeColor = System.Drawing.Color.Black;
            this.lblHora.Location = new System.Drawing.Point(286, 314);
            this.lblHora.Name = "lblHora";
            this.lblHora.Size = new System.Drawing.Size(314, 31);
            this.lblHora.TabIndex = 2;
            this.lblHora.Text = "12:05:15";
            this.lblHora.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DeepSkyBlue;
            this.ClientSize = new System.Drawing.Size(600, 366);
            this.Controls.Add(this.lblHora);
            this.Controls.Add(this.lblTitulo);
            this.Controls.Add(this.mediaPLayer);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "Form1";
            this.Text = "Form1";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.mediaPLayer)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private AxWMPLib.AxWindowsMediaPlayer mediaPLayer;
        private System.Windows.Forms.Label lblTitulo;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Label lblHora;
    }
}

